package com.bobo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created by evildoerDb on 2018/8/1 14:58
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;



    public Object getValueByKey(String key){

        return redisTemplate.opsForValue().get(key);
    }

    public void setKey(String key, String value){
        redisTemplate.opsForValue().set(key,value);
    }


}
