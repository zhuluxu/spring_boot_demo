package com.example.demo.study.singleton;

/**
 * @author didi
 */

public enum  EnumSingleton {
    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}
