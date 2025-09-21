package com.example.demo.service;

import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * 基于Redis实现的分布式消息队列服务
 * 使用两个List实现消息的可靠传递和确认机制
 * todo: 消息消费唯一键加分布式redis全局锁
 */
@Service
public class RedisMessageQueueService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    /**
     * 发送消息到队列
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void sendMessage(String queueName, String message) {
        String pendingQueue = queueName + ":pending";
        redisUtil.rpush(pendingQueue, message);
    }

    /**
     * 消费消息（非阻塞）
     * @param queueName 队列名称
     * @param messageHandler 消息处理器
     * @return 是否消费到消息
     */
    public boolean consumeMessage(String queueName, Consumer<String> messageHandler) {
        String pendingQueue = queueName + ":pending";
        String processingQueue = queueName + ":processing";

        // 原子性地将消息从未处理队列移动到处理中队列
        String message = (String) stringRedisTemplate.opsForList().rightPopAndLeftPush(pendingQueue, processingQueue);
        
        if (message != null) {
            try {
                // 处理消息
                messageHandler.accept(message);
                
                // 处理完成后从处理中队列删除消息
                removeMessageFromProcessingQueue(queueName, message);
                return true;
            } catch (Exception e) {
                // 如果处理失败，将消息重新放回未处理队列
                requeueMessage(queueName, message);
                throw e;
            }
        }
        return false;
    }

    /**
     * 阻塞式消费消息
     * @param queueName 队列名称
     * @param messageHandler 消息处理器
     * @param timeout 超时时间（秒）
     */
    public void consumeMessageBlocking(String queueName, Consumer<String> messageHandler, int timeout) {
        String pendingQueue = queueName + ":pending";
        String processingQueue = queueName + ":processing";

        try {
            // 阻塞式地将消息从未处理队列移动到处理中队列
            String message = stringRedisTemplate.opsForList().rightPopAndLeftPush(pendingQueue, processingQueue, timeout, TimeUnit.SECONDS);
            
            if (message != null) {
                try {
                    // 处理消息
                    messageHandler.accept(message);
                    
                    // 处理完成后从处理中队列删除消息
                    removeMessageFromProcessingQueue(queueName, message);
                } catch (Exception e) {
                    // 如果处理失败，将消息重新放回未处理队列
                    requeueMessage(queueName, message);
                    throw e;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error consuming message from queue: " + queueName, e);
        }
    }

    /**
     * 从处理中队列删除已处理的消息
     * @param queueName 队列名称
     * @param message 消息内容
     */
    private void removeMessageFromProcessingQueue(String queueName, String message) {
        String processingQueue = queueName + ":processing";
        // 注意：在实际应用中，可能需要更复杂的逻辑来确保删除的是正确的消息
        // 这里简化处理，直接从队列头部移除（假设是FIFO）
        stringRedisTemplate.opsForList().leftPop(processingQueue);
    }

    /**
     * 将消息重新放回未处理队列
     * @param queueName 队列名称
     * @param message 消息内容
     */
    private void requeueMessage(String queueName, String message) {
        String pendingQueue = queueName + ":pending";
        String processingQueue = queueName + ":processing";
        
        // 从processing队列中移除消息并放回pending队列头部
        stringRedisTemplate.opsForList().leftPush(pendingQueue, message);
        stringRedisTemplate.opsForList().leftPop(processingQueue);
    }

    /**
     * 恢复处理中断的消息
     * 当应用重启后，将处理中队列的消息重新放回未处理队列
     * @param queueName 队列名称
     */
    public void recoverUnprocessedMessages(String queueName) {
        String pendingQueue = queueName + ":pending";
        String processingQueue = queueName + ":processing";

        String message;
        while ((message = stringRedisTemplate.opsForList().leftPop(processingQueue)) != null) {
            // 将处理中队列的消息重新放回未处理队列头部
            stringRedisTemplate.opsForList().leftPush(pendingQueue, message);
        }
    }

    /**
     * 异步消费消息
     * @param queueName 队列名称
     * @param messageHandler 消息处理器
     */
    public void consumeMessageAsync(String queueName, Consumer<String> messageHandler) {
        executorService.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    consumeMessageBlocking(queueName, messageHandler, 5);
                } catch (Exception e) {
                    // 记录错误但继续处理
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 获取队列长度
     * @param queueName 队列名称
     * @return 队列中消息总数
     */
    public long getQueueSize(String queueName) {
        String pendingQueue = queueName + ":pending";
        String processingQueue = queueName + ":processing";
        
        long pendingCount = redisUtil.llen(pendingQueue) != null ? redisUtil.llen(pendingQueue) : 0;
        long processingCount = redisUtil.llen(processingQueue) != null ? redisUtil.llen(processingQueue) : 0;
        
        return pendingCount + processingCount;
    }
}