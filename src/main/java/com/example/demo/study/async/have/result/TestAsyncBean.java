package com.example.demo.study.async.have.result;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author didi
 */
@Component
public class TestAsyncBean {
    @Async
    public String sayHello2() throws InterruptedException {
        Thread.sleep(2 * 1000);//网络连接中 。。。消息发送中。。。
        return "我爱你啊!";// 调用方调用后会立即返回,所以返回null
    }
}
