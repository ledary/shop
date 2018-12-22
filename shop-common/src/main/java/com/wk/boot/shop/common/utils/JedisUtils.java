package com.wk.boot.shop.common.utils;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wgp on 2018/12/20.
 */
@Component
public class JedisUtils {
    public static void main(String[] args) {
        Set<String> sentinels = new HashSet<>();
        String ip = "192.168.7.129";
        String sentinelA = ip + ":26379";
        String sentinelB = ip + ":26380";
        String sentinelC = ip + ":26381";
        sentinels.add(sentinelA);
        sentinels.add(sentinelB);
        sentinels.add(sentinelC);
        String name = "mymaster";
        JedisSentinelPool sentinelPool = new JedisSentinelPool(name,sentinels);
        Jedis jedis = sentinelPool.getResource();
        jedis.set("111","12345");
        System.out.println(jedis.get("111"));

        sentinelPool.close();


    }
}
