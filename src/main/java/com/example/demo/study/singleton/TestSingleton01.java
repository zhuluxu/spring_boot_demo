package com.example.demo.study.singleton;

public class TestSingleton01 {
    public static void main(String[] args) {

        SingletonHungry singletonHungry = SingletonHungry.getInstanceHungry();
        singletonHungry.setInitA(singletonHungry.getInitA()+1);
        //1
        System.out.println(singletonHungry.getInitA());

        SingletonHungry singletonHungry2 = SingletonHungry.getInstanceHungry();
        singletonHungry2.setInitA(singletonHungry.getInitA()+1);
        //2
        System.out.println(singletonHungry2.getInitA());

        SingletonHungry singletonHungry3 = SingletonHungry.getInstanceHungry();
        singletonHungry3.setInitA(singletonHungry.getInitA()+1);
        //3
        System.out.println(singletonHungry3.getInitA());

        //始终只有一个实例对象
        singletonHungry2.setInitA(100);
        //100
        System.out.println(singletonHungry3.getInitA());

        //3
        System.out.println(singletonHungry3.getCount());

        System.out.println(User.getInstance());
        System.out.println(User.getInstance());
        System.out.println(User.getInstance()==User.getInstance());

    }
}
