package com.example.redisclusterdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Configuration
public class JedisClusterConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisCluster getJedisCluster() {
        List<String> nodesList = Arrays.asList(redisProperties.getNodes().split(";"));

        String[] split;
        HashSet<HostAndPort> nodes = new HashSet<HostAndPort>();

        for (String node : nodesList) {
            split = node.split(":");
            nodes.add(new HostAndPort(split[0].trim(), Integer.valueOf(split[1].trim())));
        }
        return new JedisCluster(nodes);
    }
}
