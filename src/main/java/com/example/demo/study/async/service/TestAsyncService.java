package com.example.demo.study.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuluxu
 * 异步执行类
 * 这个类本身要被Spring管理
 */

@Component
public class TestAsyncService {
     /**
     *添加注解表示这个方法要异步执行
     */
    @Async
    public void testAsync(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testAsync invoked");
    }
}
