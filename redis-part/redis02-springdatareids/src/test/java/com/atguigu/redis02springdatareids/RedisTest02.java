package com.atguigu.redis02springdatareids;

import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisTest02 {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("msg", "spring-data-redis02");
        Object msg = redisTemplate.opsForValue().get("msg");
        System.out.println("msg = " + msg);
    }

    @Test
    void testHash() {
        redisTemplate.opsForValue().set("user:1002",new User("lisi", 20));
        User user = (User) redisTemplate.opsForValue().get("user:1002");
        System.out.println("user = " + user);
    }
}
