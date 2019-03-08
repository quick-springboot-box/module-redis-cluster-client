package com.example.redisclusterdemo;

import com.example.redisclusterdemo.utils.RedisClusterClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterDemoApplicationTests {
    @Autowired
    private RedisClusterClient redisClientHelper;

    @Test
    public void contextLoads() {
        redisClientHelper.setString("author", "liuyiwei.dlbc");
        System.out.println("result: " + redisClientHelper.getString("author"));
    }

}
