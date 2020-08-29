package com.example.demo.study.async.have.result;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class TestAsyncBean01 {
    @Async
    public Future<String> sayHello1() throws InterruptedException {
        int thinking = 2;
        Thread.sleep(thinking * 1000);//网络连接中 。。。消息发送中。。。
        System.out.println("我爱你啊!");
        return new AsyncResult<String>("发送消息用了"+thinking+"秒");
    }
}
