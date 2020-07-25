package com.example.demo.study.singleton;

public class SingletonLazySynchronized {
    private static volatile SingletonLazySynchronized instanceLazySynchronized = null;

    private SingletonLazySynchronized() {
    }

    //运行时加载对象
    public static SingletonLazySynchronized getInstance() {
        if (instanceLazySynchronized == null) {
            synchronized(SingletonLazySynchronized.class){
                if(instanceLazySynchronized == null){
                    instanceLazySynchronized = new SingletonLazySynchronized();
                }
            }
        }
        return instanceLazySynchronized;
    }
}
