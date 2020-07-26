package com.example.demo.study.thread;

/**
 * @author zhuluxu
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("这是继承Thread的MyThread线程");
    }
}
