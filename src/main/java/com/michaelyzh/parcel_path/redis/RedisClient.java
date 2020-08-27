package com.michaelyzh.parcel_path.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * the redis component including operations on the redis database
 */
@Component
public class RedisClient {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean set(String key, String value){
        try{
            redisTemplate.opsForValue().set(key, value);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }
}
