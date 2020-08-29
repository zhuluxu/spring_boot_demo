package com.example.demo.study.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author didi
 */
public class TestThreadPollExecutor {



    public static void main(String[] args) {

        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
//        ApplicationContext context = new AnnotationConfigApplicationContext(ThreadPoolConfig.class);
//        ExecutorService commonThreadPool01 = (ExecutorService) context.getBean("commonThreadPool");
//        for (int i = 0; i < 5; i++) {
//            commonThreadPool01.submit(new MyTask("test"+i));
//        }


    }


    // 任务类

    /**
     *
     */
    static class MyTask implements Runnable {

        private String name;
        private Random r = new Random();

        public MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {// 执行任务
            try {
                Thread.sleep(r.nextInt(1000)+2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getId()+" sleep InterruptedException:"
                        +Thread.currentThread().isInterrupted());
            }
            System.out.println("任务 " + name + " 完成");
        }
    }
}
