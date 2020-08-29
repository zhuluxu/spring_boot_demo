package com.example.demo.study.thread.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author didi
 */
public class SumArray {
    private static class SumTask extends RecursiveTask<Integer> {

        //阈值，数组大小的五分之一
        private final static int THRESHOLD = MakeArray.ARRAY_LENGTH/5;
        private int[] src; //表示我们要实际统计的数组
        private int fromIndex;//开始统计的下标
        private int toIndex;//统计到哪里结束的下标

        public SumTask(int[] src, int fromIndex, int toIndex) {
            this.src = src;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        protected Integer compute() {
            //在阈值内执行任务逻辑
            if(toIndex-fromIndex < THRESHOLD) {
                int count = 0;
                for(int i=fromIndex;i<=toIndex;i++) {
                    //SleepTools.ms(1);
                    count = count + src[i];
                }
                return count;
            }else {
                //取中位数分割任务
                //fromIndex....mid....toIndex
                //1...................70....100
                int mid = (fromIndex+toIndex)/2;
                SumTask left = new SumTask(src,fromIndex,mid);
                SumTask right = new SumTask(src,mid+1,toIndex);
                invokeAll(left,right);
                System.out.println("========");
                return left.join()+right.join();
            }
        }
    }


    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();
        //生成一个随机数组，大小 ARRAY_LENGTH  = 10;
        int[] src = MakeArray.makeArray();
        SumTask innerFind = new SumTask(src,0,src.length-1);

        long start = System.currentTimeMillis();

        //同步调用
        pool.invoke(innerFind);
        System.out.println("Task is Running.....");

        System.out.println("The count is "+innerFind.join()
                +" spend time:"+(System.currentTimeMillis()-start)+"ms");

    }
}
