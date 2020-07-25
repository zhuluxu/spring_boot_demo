package com.example.demo.study.singleton;

/**
 * @author didi
 * 懒汉式，线程不安全
 */
public class SingletonLazy {

    //线程不安全的
    //在多线程环境下，但A.B两个线程都进入 if(singleton == null)，此时有可能会生成两个对象，所以是线程不安全的

    private static SingletonLazy instanceLazy = null;

    private SingletonLazy() {
    }

    //运行时加载对象
    public static SingletonLazy getInstance() {
        if (instanceLazy == null) {
            instanceLazy = new SingletonLazy();
        }
        return instanceLazy;
    }
}
