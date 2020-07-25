package com.example.demo.study.singleton;

/**
 * @author
 * 使用静态内部类实现
 */
public class SingletonLazyStatic {
    private static class LazyHolder {
        private static final SingletonLazyStatic INSTANCE = new SingletonLazyStatic();
    }
    private SingletonLazyStatic (){}
    public static final SingletonLazyStatic getInstance() {
        return LazyHolder.INSTANCE;
    }
}
