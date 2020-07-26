package com.example.demo.study.thread;

/**
 * @author zhuluxu
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("这是实现Runnable的MyRunnable线程");
    }
}
