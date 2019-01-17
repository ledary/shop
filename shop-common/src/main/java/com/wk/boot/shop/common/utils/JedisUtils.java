package com.wk.boot.shop.common.utils;

import com.wk.boot.shop.common.dto.MallStockDto;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;
import redis.clients.jedis.util.JedisClusterCRC16;

import java.math.BigDecimal;
import java.util.*;

/**
 * Jedis 哨兵工具类
 * Created by wgp on 2018/12/20.
 */
@Component
public class JedisUtils {
    public static void main(String[] args) {
//        JedisUtils.testRedisCluster();
        JedisUtils.testSolt();
    }

    public static void testRedisCluster(){
        Set<HostAndPort> nodes = new HashSet<>();
        String ip = "192.168.5.129";
        int port = 7001;
        nodes.add(new HostAndPort(ip,port));
        nodes.add(new HostAndPort(ip,port+1));
        nodes.add(new HostAndPort(ip,port+2));
        nodes.add(new HostAndPort(ip,port+3));
        nodes.add(new HostAndPort(ip,port+4));
        nodes.add(new HostAndPort(ip,port+5));

        JedisCluster jedisCluster = new JedisCluster(nodes);

        MallStockDto dto = new MallStockDto();
        dto.setControlType(1);
        dto.setHoldNum(new BigDecimal(100));
        dto.setOwnerId(1);
        dto.setSkuId(1001);
        dto.setStockNum(new BigDecimal(200));
        dto.setWarehouseId(1);
        String key = dto.getKey();
        Map<String,String> map = new HashMap<>();
        map.put("holdNum",dto.getHoldNum().toString());
        map.put("skuId",dto.getSkuId().toString());
        map.put("stockNum",dto.getStockNum().toString());
        map.put("skuId",dto.getSkuId().toString());
        map.put("warehouseId",dto.getWarehouseId().toString());
        map.put("ownerId",dto.getOwnerId().toString());
        map.put("controlType",dto.getControlType().toString());
        jedisCluster.hmset(key,map);

        System.out.println(jedisCluster.hget(key,"skuId"));
    }

    public void testSentinels(){
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

    public static void testSolt(){
        Set<HostAndPort> nodes = new HashSet<>();
        String ip = "192.168.5.129";
        int port = 7001;
        nodes.add(new HostAndPort(ip,port));
        nodes.add(new HostAndPort(ip,port+1));
        nodes.add(new HostAndPort(ip,port+2));
        nodes.add(new HostAndPort(ip,port+3));
        nodes.add(new HostAndPort(ip,port+4));
        nodes.add(new HostAndPort(ip,port+5));

        JedisCluster jedisCluster = new JedisCluster(nodes);
        Map<String, JedisPool> nodeMap = jedisCluster.getClusterNodes();
        String anyHost = nodeMap.keySet().iterator().next();
        TreeMap<Long,String> slotHostMap = getSlotHostMap(anyHost);
        String key = "1001_1_1{1}";
        int slot = JedisClusterCRC16.getSlot(key);
        Map.Entry<Long, String> entry = slotHostMap.lowerEntry(Long.valueOf(slot));

        Jedis jedis = nodeMap.get(entry.getValue()).getResource();
        jedis.set("123{1}","kk");
        jedis.pipelined();

    }

    private static TreeMap<Long,String> getSlotHostMap(String anyHostAndPortStr){
        TreeMap<Long, String> tree = new TreeMap<Long, String>();
        String parts[] = anyHostAndPortStr.split(":");
        HostAndPort anyHostAndPort = new HostAndPort(parts[0], Integer.parseInt(parts[1]));
        try{
            Jedis jedis = new Jedis(anyHostAndPort.getHost(), anyHostAndPort.getPort());
            List<Object> list = jedis.clusterSlots();
            for (Object object : list) {
                List<Object> list1 = (List<Object>) object;
                List<Object> master = (List<Object>) list1.get(2);
                String hostAndPort = new String((byte[]) master.get(0)) + ":" + master.get(1);
                tree.put((Long) list1.get(0), hostAndPort);
                tree.put((Long) list1.get(1), hostAndPort);
            }
            jedis.close();
        }catch(Exception e){

        }
        return tree;
    }

}
