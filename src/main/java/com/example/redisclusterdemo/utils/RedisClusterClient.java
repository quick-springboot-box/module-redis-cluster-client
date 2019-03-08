package com.example.redisclusterdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

@Component
@DependsOn("jedisClusterConfig")
public class RedisClusterClient {

    @Autowired
    private JedisCluster jedisCluster;

    public boolean setString(String key, String value) {
        String set = jedisCluster.set(key, value);
        System.out.println(set);
        return true;
    }

    public String getString(String key){
        return jedisCluster.get(key);
    }
}
