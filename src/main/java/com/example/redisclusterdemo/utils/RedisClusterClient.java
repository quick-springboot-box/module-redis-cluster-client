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

    public boolean setNxString(String key, String value){
        Long setnx = jedisCluster.setnx(key, value);
        return setnx == 1? true:false;
    }


    public String setExString(String key, String value){
        String setex = jedisCluster.setex(key, 10, value);
        return setex;
    }

    public String msetSTring(String... args){
        String mset = jedisCluster.mset(args);
        return mset;
    }

    public String getString(String key){
        return jedisCluster.get(key);
    }
}
