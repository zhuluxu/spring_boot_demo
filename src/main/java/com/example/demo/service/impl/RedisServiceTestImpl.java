package com.example.demo.service.impl;

import com.example.demo.service.RedisServiceTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author didi
 */
@Service
public class RedisServiceTestImpl implements RedisServiceTest {


    @Override
    @Cacheable(value = "Number",keyGenerator = "keyGenerator")
    public Integer getNumber(Integer init) {

        return init++;
    }

    @Override
    @Cacheable(value = "Number2",keyGenerator = "testKeyGenerator")
    public Integer getNumber2(Integer init) {

        return init++;
    }

}
