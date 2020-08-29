package com.example.demo.study.thread.wait.notify;

/**
 * @author didi
 */
public class ThreadB extends Thread {
    static int total;
    @Override
    public void run() {
        synchronized (ThreadA.o1) {
            System.out.println("ThreadB is running..");



            for (int i = 0; i < 5; i++) {
                total += i;
                System.out.println("ThreadB :total is " + total);
            }
            try {
                System.out
                        .println("Waiting for a to complete...");
                ThreadA.o1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            ThreadA.o1.notifyAll();
        }

    }
}
