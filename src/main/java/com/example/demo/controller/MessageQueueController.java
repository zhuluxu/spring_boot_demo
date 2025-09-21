package com.example.demo.controller;

import com.example.demo.service.RedisMessageQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 消息队列测试Controller
 */
@RestController
@RequestMapping("/mq")
public class MessageQueueController {

    @Autowired
    private RedisMessageQueueService messageQueueService;

    /**
     * 发送消息
     * @param queueName 队列名称
     * @param message 消息内容
     * @return 操作结果
     */
    @PostMapping("/send")
    public String sendMessage(@RequestParam String queueName, @RequestParam String message) {
        messageQueueService.sendMessage(queueName, message);
        return "Message sent successfully";
    }

    /**
     * 消费消息（非阻塞）
     * @param queueName 队列名称
     * @return 操作结果
     */
    @GetMapping("/consume")
    public String consumeMessage(@RequestParam String queueName) {
        boolean consumed = messageQueueService.consumeMessage(queueName, message -> {
            System.out.println("Consumed message: " + message);
            // 模拟消息处理
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        if (consumed) {
            return "Message consumed successfully";
        } else {
            return "No message to consume";
        }
    }

    /**
     * 获取队列大小
     * @param queueName 队列名称
     * @return 队列大小
     */
    @GetMapping("/size")
    public String getQueueSize(@RequestParam String queueName) {
        long size = messageQueueService.getQueueSize(queueName);
        return "Queue size: " + size;
    }
}