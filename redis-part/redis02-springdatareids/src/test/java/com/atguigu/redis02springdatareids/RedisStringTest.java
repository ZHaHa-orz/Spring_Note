package com.atguigu.redis02springdatareids;

import com.atguigu.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
public class RedisStringTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // json工具
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testString() throws JsonProcessingException {
        // 创建对象
        User user = new User("lisi", 18);
        // 手动序列化
        String json = mapper.writeValueAsString(user);
        // 写入数据
        stringRedisTemplate.opsForValue().set("user:1003", json);

        // 获取数据
        String userJson = stringRedisTemplate.opsForValue().get("user:1003");
        // 手动反序列化
        User user1 = mapper.readValue(userJson, User.class);
        System.out.println("user1 = " + user1);
    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:1004", "name", "lisi");
        stringRedisTemplate.opsForHash().put("user:1004", "age", "18");
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:1004");
        System.out.println("entries = " + entries);
    }
}
