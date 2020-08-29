package com.example.demo.study.thread.wait.notify;

/**
 * @author didi
 */
public class ThreadA extends Thread {
    /**
     * 可以是任意一个对象，或者自定义的对象
     */
    static Object o1 = new Object();

    @Override
    public void run() {
        synchronized (ThreadA.o1) {
            /**
             * 释放o1的对象锁，通知其他等待o1对象锁的线程继续运行
             *
             *
             */
            ThreadB.total++;
            System.out.println("ThreadA: total is "+ThreadB.total);
            o1.notifyAll();
            System.out.println("ThreadA Completed！");
        }
    }


    //
//    public static void main(String[] args) {
//        ThreadB b = new ThreadB();
//        b.start();
//        System.out.println("b is start....");
//
//
//        /**
//         * 主线程获取o1的对象锁
//         * */
//        synchronized (o1)
//        {
//            try {
//                System.out
//                        .println("Waiting for b to complete...");
////                o1.wait(2000);//o1的对象锁释放，主线程进入等待状态
//                o1.wait();
//                System.out
//                        .println("Completed.Now back to main thread");
//
//            } catch (InterruptedException e) {
//            }
//        }
//
//    }

    //

}

