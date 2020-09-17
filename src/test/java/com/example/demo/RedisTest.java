package com.example.demo;


import com.example.demo.service.RedisServiceTest;
import com.example.demo.util.RedisUtil;
import com.example.demo.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private RedisServiceTest redisServiceTest;

    @Test
    void testCon(){
        redisUtil.set("testKey","success");
    }

    @Test
    void testGet(){
//        String testKey = redisUtil.get("testKey");
        String testKey2 = redisUtil.get("Number::com.example.demo.service.impl.RedisServiceTestImplgetNumber2");
        System.out.println(testKey2);
    }

    @Test
    void testKey(){
        Integer number = redisServiceTest.getNumber(2);

        Integer number2 = redisServiceTest.getNumber(3);

        Integer number3 = redisServiceTest.getNumber(4);

        Integer number4 = redisServiceTest.getNumber2(5);

        System.out.println(number4);
    }
}
