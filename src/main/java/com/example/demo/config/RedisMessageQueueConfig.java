package com.example.demo.config;

import com.example.demo.service.RedisMessageQueueService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Redis消息队列配置类
 * 在应用启动时恢复未处理的消息
 */
@Component
public class RedisMessageQueueConfig {

    @Resource
    private RedisMessageQueueService redisMessageQueueService;

    /**
     * 应用启动时恢复所有队列中未处理的消息
     */
    @PostConstruct
    public void recoverAllQueues() {
        // 定义需要恢复的队列名称列表
        List<String> queueNames = Arrays.asList("default", "email", "notification");
        
        for (String queueName : queueNames) {
            try {
                redisMessageQueueService.recoverUnprocessedMessages(queueName);
                System.out.println("Recovered unprocessed messages for queue: " + queueName);
            } catch (Exception e) {
                System.err.println("Failed to recover messages for queue: " + queueName + ", error: " + e.getMessage());
            }
        }
    }
}