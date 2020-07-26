package com.example.demo.study.thread;

/**
 * @author didi
 */
public class ThreadImpl {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("MyThread");
        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.setName("MyRunnable");
        System.out.println("main Thread begin");
        myThread.start();
        myRunnable.start();
        System.out.println("main Thread end");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
