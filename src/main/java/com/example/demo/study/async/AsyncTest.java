package com.example.demo.study.async;

import com.example.demo.study.async.service.TestAsyncService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhuluxu
 */
public class AsyncTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        TestAsyncService bean = ac.getBean(TestAsyncService.class);
        bean.testAsync();
        System.out.println("main函数执行完成");
    }
}
