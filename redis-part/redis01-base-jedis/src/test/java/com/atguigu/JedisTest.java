package com.atguigu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setup() {
        // 1.创建jedis对象
        jedis = new Jedis("127.0.0.1", 6379);
        // 2.设置密码
        // jedis.auth("123456");
        // 3.选择库
        jedis.select(0);
    }

    @Test
    void testString() {
        // 4.操作
        String ping = jedis.ping();
        System.out.println(ping);
        // 5.设置值
        String result = jedis.set("name", "zhangsan");
        System.out.println("result = " + result);
        // 6.获取值
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }

    @Test
    void testHash() {
        // 插入hash数据
        jedis.hset("user:1001", "name", "zhangsan");
        jedis.hset("user:1001", "age", "18");
        // 获取
        Map<String, String> map = jedis.hgetAll("user:1001");
        System.out.println("map = " + map);
    }

    @Test
    void testList() {
        // 插入list数据
        jedis.lpush("mylist", "a", "b", "c");
        // 获取
        String element = jedis.lpop("mylist");
        System.out.println("element = " + element);
    }

    @Test
    void testSet() {
        // 插入set数据
        jedis.sadd("myset", "a", "b", "c");
        // 获取
        Long size = jedis.scard("myset");
        System.out.println("size = " + size);
    }

    @Test
    void testZset() {
        // 插入zset数据
        jedis.zadd("myzset", 1, "a");
        jedis.zadd("myzset", 2, "b");
        jedis.zadd("myzset", 3, "c");
        // 获取
        Long size = jedis.zcard("myzset");
        System.out.println("size = " + size);
    }

    @AfterEach
    void destroy() {
        // 7.关闭连接
        if (jedis != null) {
            jedis.close();
        }
    }

}
