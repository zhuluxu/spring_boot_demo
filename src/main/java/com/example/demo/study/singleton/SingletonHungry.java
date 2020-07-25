package com.example.demo.study.singleton;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhuluxu
 *饿汉式，先创建对象 后判断
 */
@AllArgsConstructor
@Data
public class SingletonHungry {

        private Integer initA;
        private Integer count;

        //线程安全的
        //类初始化时，立即加载这个对象
        private static SingletonHungry instanceHungry = new SingletonHungry();

        private SingletonHungry() {
                initA=0;
                count=0;
        }


        //方法没有加同步块，所以它效率高
        //静态代码块尽量不要处理变量等逻辑，每次得到实例对象，都会走一遍，可有一些计数,共用了几次
        public static SingletonHungry getInstanceHungry() {
                instanceHungry.setCount(instanceHungry.getCount()+1);
            return instanceHungry;
        }

}
