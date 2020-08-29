package com.example.demo.study.thread.pool;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author didi
 */
public class MyTaskPoolTest implements Runnable  {
    private String name;
    private Random r = new Random();
    public static Integer count = 1;
    public MyTaskPoolTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {// 执行任务
        count++;
        try {
            Thread.sleep(r.nextInt(1000)+2000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getId()+" sleep InterruptedException:"
                    +Thread.currentThread().isInterrupted());
        }
        System.out.println("任务 " + name + " 完成");
    }
}

