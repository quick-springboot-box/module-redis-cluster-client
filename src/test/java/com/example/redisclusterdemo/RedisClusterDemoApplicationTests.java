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
        boolean author = redisClientHelper.setNxString("author1", "liuyiwei.dlbc@gmail.com");
        System.out.println("set nx is "  + author);

        String author2 = redisClientHelper.setExString("author2", "javafish2006@163.com");
        System.out.println("author2 :" +author2);

        //throw exception: redis.clients.jedis.exceptions.JedisClusterOperationException:
        // No way to dispatch this command to Redis Cluster because keys have different slots.
        String s = redisClientHelper.msetSTring("a", "1", "b", "2");
        System.out.println("mset result : " + s);
    }

}
