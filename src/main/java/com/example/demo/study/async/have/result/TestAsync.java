package com.example.demo.study.async.have.result;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author didi
 */
public class TestAsync {
    @Autowired
    private TestAsyncBean01 testAsyncBean01;
    @Test
    public void test_sayHello1() throws InterruptedException, ExecutionException {
        Future<String> future = null;
        System.out.println("你不爱我了么?");
        future = testAsyncBean01.sayHello1();
        System.out.println("你竟无话可说, 我们分手吧。。。");
        Thread.sleep(3 * 1000);// 不让主进程过早结束
        System.out.println(future.get());
    }
}
