package com.example.demo.config.redis.lettuce;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import javax.annotation.Resource;

/**
 * @author didi
 */
public class TestRedisLettuce {

    @Resource(name = "redisConnectionFactory")
    private static  LettuceConnectionFactory redisConnectionFactory;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(LettuceAppConfig.class);
        LettuceConnectionFactory redisConnectionFactory01 = (LettuceConnectionFactory) annotationConfigApplicationContext.getBean("redisConnectionFactory");

        System.out.println(redisConnectionFactory01.getHostName());
        System.out.println(redisConnectionFactory01.getConnection().toString());
        System.out.println(redisConnectionFactory01.getConnection().isClosed());
    }
}
