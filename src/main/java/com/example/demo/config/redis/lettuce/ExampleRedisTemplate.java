package com.example.demo.config.redis.lettuce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.net.URL;

/**
 * @author didi
 */
public class ExampleRedisTemplate {

    @Autowired
    private RedisTemplate<String, String> template;

    @Resource(name="redisTemplate")
    private  ListOperations<String, String> listOps;

    public void addLink(String userId, URL url) {
        listOps.leftPush(userId, url.toExternalForm());
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(RedisTemplateConfig.class);
        RedisTemplate<String, String> redisTemplate = (RedisTemplate<String, String>) annotationConfigApplicationContext.getBean("redisTemplate");
        redisTemplate.renameIfAbsent("1", "baidu");
    }


}
