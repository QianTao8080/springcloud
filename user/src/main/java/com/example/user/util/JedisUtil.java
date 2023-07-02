package com.example.user.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisUtil {

    @Autowired
    private JedisPool jedisPool;

    public void set(int poolDb, String key, String val) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(poolDb);
        jedis.set(key, val);
    }

    public String get(int poolDb, String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(poolDb);
        return jedis.get(key);
    }
}
