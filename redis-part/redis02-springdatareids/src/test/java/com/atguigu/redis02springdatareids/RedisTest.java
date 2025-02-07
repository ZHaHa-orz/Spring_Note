package com.atguigu.redis02springdatareids;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("msg", "spring-data-redis");
        Object msg = redisTemplate.opsForValue().get("msg");
        System.out.println("msg = " + msg);
    }
}
