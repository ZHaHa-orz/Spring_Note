package com.atguigu;

import com.atguigu.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class JedisPoolTest {
    private Jedis jedis;

    @BeforeEach
    public void init() {
        // 1. 获取jedis
        jedis = JedisConnectionFactory.getJedis();
        // 2. 配置连接池信息
        // jedis.auth("123456");
        // 3. 选择库
        jedis.select(0);
    }

    @Test
    void testString() {
        // 4.操作
        String ping = jedis.ping();
        System.out.println(ping);
        // 5.设置值
        String result = jedis.set("name", "lisi");
        System.out.println("result = " + result);
        // 6.获取值
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }

    @AfterEach
    void destroy() {
        // 7.关闭连接
        if (jedis != null) {
            jedis.close();
        }
    }
}
