package com.example.demo.study.thread.wait;

/**
 * @author didi
 */
public class UseJoin {
    static class JumpQueue extends Thread {
        private Thread thread;//用来插队的线程

        public JumpQueue(Thread thread) {
            this.thread = thread;
        }


        @Override
        public void run() {
            try {
                System.out.println(thread.getName()+" will be join before "
                        +Thread.currentThread().getName());
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" terminted.");
        }
    }

    public static void main(String[] args) throws Exception {
        //现在是主线程
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            //i=0,previous 是主线程，i=1;previous是i=0这个线程
            Thread thread =
                    new Thread(new JumpQueue(previous), String.valueOf(i));
//            JumpQueue thread = new JumpQueue();
//            thread.setThread(previous);
//            thread.setName(String.valueOf(i));
            System.out.println(previous.getName()+" jump a queue the thread:"
                    +thread.getName());
            thread.start();
            previous = thread;
        }
        //让主线程休眠2秒
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }
}
