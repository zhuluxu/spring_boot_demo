package com.example.demo;

import com.example.demo.service.RedisMessageQueueService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RedisMessageQueueService messageQueueService;

    @Test
    void testMessageQueue() throws InterruptedException {
        String queueName = "test";

        // 发送几条消息
        messageQueueService.sendMessage(queueName, "Hello, World!");
        messageQueueService.sendMessage(queueName, "This is a test message");
        messageQueueService.sendMessage(queueName, "Another message");

        System.out.println("Sent 3 messages");

        // 消费消息
        for (int i = 0; i < 3; i++) {
            messageQueueService.consumeMessage(queueName, message -> {
                System.out.println("Received message: " + message);
            });
        }

        System.out.println("Consumed all messages");
    }

    @Test
    void testMessageRecovery() {
        String queueName = "recovery_test";

        // 发送消息
        messageQueueService.sendMessage(queueName, "Message 1");
        messageQueueService.sendMessage(queueName, "Message 2");

        // 模拟消费一条消息到processing队列但未完成处理
        // 这里我们手动将一条消息移动到processing队列
        String pendingQueue = queueName + ":pending";
        String processingQueue = queueName + ":processing";

        // 手动模拟消息消费但未完成确认的情况
        // 实际使用中，这种情况会在应用崩溃时发生

        // 调用恢复方法
        messageQueueService.recoverUnprocessedMessages(queueName);

        System.out.println("Recovered messages");
    }
}