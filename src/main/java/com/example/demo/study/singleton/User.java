package com.example.demo.study.singleton;

/**
 * @author didi
 */
public class User {
    private String lastName;
    private Integer numbers;
    //私有化构造函数 初始化
    private User(){
        lastName="zhangsan";
        numbers=0;
    }

    //定义一个静态枚举类
    static enum SingletonEnum{
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private User user;
        //私有化枚举的构造函数,初始化一个对象实例
        private SingletonEnum(){
            user=new User();
        }
        //公开获取初始化的对象实例
        public User getInstnce(){
            return user;
        }
    }

    //对外暴露一个获取User对象的静态方法
    public static User getInstance(){
        return SingletonEnum.INSTANCE.getInstnce();
    }
}
