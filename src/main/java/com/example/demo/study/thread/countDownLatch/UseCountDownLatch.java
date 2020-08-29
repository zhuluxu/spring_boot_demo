package com.example.demo.study.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch {
    static CountDownLatch latch = new CountDownLatch(6);

    //一个个初始化线程(只有一步，有4个)，扣除一个
    private static class InitThread implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread_"+Thread.currentThread().getId()
                    +" ready init work......");
            latch.countDown();//初始化线程完成工作了，countDown方法只扣减一次；
            for(int i =0;i<2;i++) {
                System.out.println("Thread_"+Thread.currentThread().getId()
                        +" ........continue do its work");
            }
        }
    }

    //业务线程
    private static class BusinessThread implements Runnable{

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i =0;i<3;i++) {
                System.out.println("BusiThread_"+Thread.currentThread().getId()
                        +" do business-----");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //单独的初始化线程,初始化分为2步，需要扣减两次,有6-2个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
//                sleep(1000); //休眠1s
                System.out.println("Thread_"+Thread.currentThread().getId()
                        +" ready init work step 1st......");
                latch.countDown();//每完成一步初始化工作，扣减一次
                System.out.println("begin step 2nd.......");
//                SleepTools.ms(1);
                System.out.println("Thread_"+Thread.currentThread().getId()
                        +" ready init work step 2nd......");
                latch.countDown();//每完成一步初始化工作，扣减一次
            }
        }).start();
        new Thread(new BusinessThread()).start();
        for(int i=0;i<=3;i++){
            Thread thread = new Thread(new InitThread());
            thread.start();
        }

        latch.await();
        System.out.println("Main do ites work........");
    }
}
