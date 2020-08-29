package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author didi
 */
@Service
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 执行set操作
     *
     * @param key
     * @return
     */
    public void set(final String key,final String value) {
        stringRedisTemplate.opsForValue().set(key,value);
    }

    /**
     * 执行get操作
     * @param key
     * @return
     */
    public String get(final String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 执行delete操作
     *
     * @param key
     * @return
     */
    public boolean del(final String key) {
        return stringRedisTemplate.delete(key);
    }


    /**
     * 执行set操作并且设置生存时间，单位为：秒
     *
     * @param key
     * @param value //TimeUnit.SECONDS 秒
     *              //TimeUnit.MINUTES 分
     * @return
     */
    public void set(final String key, final String value, final Integer seconds) {
        stringRedisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }


    /**
     * 执行hset操作
     *
     * @param key
     * @param
     * @return
     */
    public void hset(final String key, final String mapkey, final String mapvalue) {
        stringRedisTemplate.opsForHash().put(key, mapkey, mapvalue);
    }

    /**
     * 执行hgetAll操作
     *
     * @param key
     * @param
     * @return
     */
    public Map<String, String> hgetAll(final String key) {
        return (Map)stringRedisTemplate.opsForHash().entries(key);
    }

    /**
     * 执行hdel操作
     *
     * @param key
     * @param
     * @return
     */
    public long hdel(final String key, final String[] strings) {
        return stringRedisTemplate.opsForHash().delete(key, strings);
    }


    /**
     * 执行hkeys操作
     *
     * @param
     * @param key
     * @return
     */
    public Set<String> hkeys(final String key) {
        return (Set) stringRedisTemplate.opsForHash().keys(key);
    }


    /**
     * 执行hvalues操作
     *
     * @param
     * @param key
     * @return
     */
    public List<String> hvalues(final String key) {
        return (List) stringRedisTemplate.opsForHash().values(key);
    }


    /**
     * 执行hget操作
     *
     * @param
     * @param key
     * @return
     */
    public String hget(final String key, final String mapkey) {
        return (String)stringRedisTemplate.opsForHash().get(key, mapkey);
    }

    /**
     * 执行hmset操作
     *
     * @param
     * @param key
     * @return
     */
    public void hmset(final String key, final Map<String, String> mapvalue) {
        stringRedisTemplate.opsForHash().putAll(key, mapvalue);
    }


    /**
     * 执行lpush操作
     * @param
     * @param key
     * @return
     */
    public long lpush(final String key,final String value) {
        return stringRedisTemplate.opsForList().leftPush(key,value);
    }

    /**
     * 执行lpop操作
     * @param
     * @param key
     * @return
     */
    public String lpop(final String key) {
        return stringRedisTemplate.opsForList().leftPop(key);
    }

    /**
     * 执行rpop操作
     * @param
     * @param key
     * @return
     */
    public String rpop(final String key) {
        return stringRedisTemplate.opsForList().rightPop(key);
    }

    /**
     * 执行list操作
     * 在列表中的尾部添加一个个值，返回列表的长度
     *
     * @param key
     * @return
     */
    public Long rpush(final String key, final String value) {
        return stringRedisTemplate.opsForList().rightPush(key,value);
    }

    /**
     * 执行list操作
     * 在列表中的尾部添加多个值，返回列表的长度
     *
     * @param key
     * @return
     */
    public Long rpush(final String key, final String[] value) {
        return stringRedisTemplate.opsForList().rightPushAll(key,value);
    }
    /**
     * 执行list操作
     * 获取List列表
     *
     * @param key
     * @return
     */
    public List<String> lrange(final String key, final long start, final long end) {
        return stringRedisTemplate.opsForList().range(key,start,end);
    }


    /**
     * 执行list操作
     * 通过索引获取列表中的元素
     *
     * @param key
     * @return
     */
    public String lindex(final String key, final long index) {
        return stringRedisTemplate.opsForList().index(key,index);
    }

    /**
     * 执行list操作
     * 获取列表长度，key为空时返回0
     *
     * @param key
     * @return
     */
    public Long llen(final String key) {
        return stringRedisTemplate.opsForList().size(key);
    }


    public boolean expire(final String key, final Integer seconds) {
        return stringRedisTemplate.expire(key,seconds, TimeUnit.SECONDS);
    }

}
