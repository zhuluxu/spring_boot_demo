package com.example.demo.study.thread;

import java.util.concurrent.ExecutionException;

/**
 * @author zhuluxu
 */
public class DaemonThread {

    private static class UseThread extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println(Thread.currentThread().getName()
                            + " I am extends Thread.");
                }
                System.out.println(Thread.currentThread().getName()
                        + " interrupt flag is " + isInterrupted());
            } finally {
                System.out.println("...........finally");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        UseThread useThread = new UseThread();
        useThread.start();
        Thread.sleep(5);
        useThread.interrupt();
    }
}
