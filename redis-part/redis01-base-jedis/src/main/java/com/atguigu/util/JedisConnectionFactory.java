package com.atguigu.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static JedisPool jedisPool;

    static {
        // 配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(10);
        // 最大空闲连接数
        poolConfig.setMaxIdle(5);
        // 最小空闲连接数
        poolConfig.setMinIdle(5);
        // 获取连接时的最大等待毫秒数 10秒
        poolConfig.setMaxWaitMillis(1000 * 10);
        jedisPool = new JedisPool(poolConfig,
                "127.0.0.1",
                6379,
                1000 * 10);
        System.out.println("jedisPool:" + jedisPool);
    }

    public static JedisPool getJedisPool() {
        return jedisPool;
    }

    public static Jedis getJedis() {
        return getJedisPool().getResource();
    }
}
