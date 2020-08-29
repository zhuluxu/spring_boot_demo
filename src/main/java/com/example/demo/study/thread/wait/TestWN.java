package com.example.demo.study.thread.wait;

import lombok.SneakyThrows;

/**
 * @author didi
 */
public class TestWN {
    /**
     * 静态类express
     * */
    private static Express express = new Express(0,Express.CITY);


    /**检查里程数变化的线程,不满足条件，线程一直等待*/
    private static class CheckKm extends Thread{
        @Override
        public void run() {
//            express.waitKm();
            synchronized (express) {
                while(express.getKm()<=100) {
                    try {
                        express.wait();
                        System.out.println("check km thread["+Thread.currentThread().getId()
                                +"] is waiting be notifed.");

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println("the km is"+express.getKm()+",I will change db.");
            }
        }

    }

    /**检查地点变化的线程,不满足条件，线程一直等待*/
    private static class CheckSite extends Thread{
        @Override
        public void run() {
            express.waitSite();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        /**三个检测地点等待线程*/
        for(int i=0;i<3;i++){
            new CheckSite().start();
        }
        /**三个检测里程数等待线程*/
        for(int i=0;i<3;i++){
            new CheckKm().start();
        }

        Thread.sleep(1000);

        /**快递里程变化*/
//        express.changeKm(1000);
        synchronized (express) {
            express.setKm(1000);
            express.notifyAll();
        }

        /**快递里程变化*/
        express.changeSite("HangZhou");
    }

}
