package com.example.demo.study.thread.wait.notify;

/**
 * @author didi
 */
public class Test {


    public static void main(String[] args) {

        ThreadB b = new ThreadB();
        b.start();
        System.out.println("b is start....");

        ThreadA a = new ThreadA();
        a.start();
        System.out.println("a is start....");

        /**
         * 主线程获取o1的对象锁
         * */
        synchronized (ThreadA.o1)
        {
                System.out.println("Completed.Now back to main thread");

        }
    }
}
