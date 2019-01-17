package com.wk.boot.shop.common.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;

import java.util.TreeMap;

/**
 * 描述:
 * redis-cluster hashTag操作类
 *
 * @author 武刚鹏
 * @create 2017-01-07 22:01
 */
public class RedisClusterUtils {

    private static JedisCluster jedisCluster;

    private static TreeMap<Long,String> slotMap;


    /**
     * 获取配置文件，初始化jedisCluster
     */
    static {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("redis.xml");
        jedisCluster = (JedisCluster) ctx.getBean("jedisCluster");
    }

//    /**
//     * 设值
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public static boolean set(String key, String value) {
//        if (null == key || null == value || ("").equals(key) || ("").equals(value)) {
//            return false;
//        }
//        try {
//            jedisCluster.set(key, value);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }
//
//    /**
//     * 设值
//     *
//     * @param key
//     * @param value
//     * @param expire 过期时间
//     * @return
//     */
//    public static boolean set(String key, String value, int expire) {
//        if (null == key || null == value) {
//            return false;
//        }
//
//        try {
//            if (expire > 0) {
//                jedisCluster.setex(key, expire, value);
//            } else {
//                jedisCluster.set(key, value);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }
//
//
//    /**
//     * 设值
//     *
//     * @param key
//     * @param map
//     * @return
//     */
//    public static boolean hmset(String key, Map map) {
//        if (null == key) {
//            return false;
//        }
//        try {
//            jedisCluster.hmset(key, map);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }
//
//    /**
//     * 把value追加到key 的原值上
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public static boolean append(String key, String value) {
//        if (null == key || null == value) {
//            return false;
//        }
//        try {
//            jedisCluster.append(key, value);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }
//
//    /**
//     * 获取value
//     *
//     * @param key
//     * @return
//     */
//    public static String get(String key) {
//        String result = null;
//        if (null == key) {
//            return result;
//        }
//        try {
//            result = jedisCluster.get(key);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//    /**
//     * 删除0
//     *
//     * @param key
//     * @return
//     */
//    public static boolean delete(String key) {
//        if (null == key) {
//            return false;
//        }
//        try {
//            jedisCluster.del(key);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }
//
//
//    /**
//     * 判断key是否存在
//     */
//    public static boolean exists(String key) {
//        boolean result = false;
//        if (null == key) {
//            return result;
//        }
//        try {
//            result = jedisCluster.exists(key);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//    /**
//     * 将 key 中储存的数字值减一
//     */
//
//    public static Long decr(String key) {
//        Long result = null;
//        if (null == key) {
//            return result;
//        }
//        try {
//            result = jedisCluster.decr(key);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//    /**
//     * 将 key 中储存的数字值加 一
//     */
//    public static Long incr(String key) {
//        Long result = null;
//        if (null == key) {
//            return result;
//        }
//        try {
//            result = jedisCluster.incr(key);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//    /**
//     * 先进先出
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public static boolean lpush(String key, String value) {
//        if (null == key || null == value) {
//            return false;
//        }
//        try {
//            jedisCluster.lpush(key, value);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }
//
//
//    /**
//     * 删除列表元素
//     * @param key
//     * @param count
//     * @param value
//     * @return
//     */
//    public static long lrem(String key,long count, String value) {
//        if (null == key || null == value) {
//            //删除失败，返回"-1"
//            return -1;
//        }
//        Long remainCount = -1L ;
//        try {
//            remainCount = jedisCluster.lrem(key, count, value);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return remainCount;
//    }
//
//    /**
//     * 获取list值
//     *
//     * @param key
//     * @param start
//     * @param end
//     * @return
//     */
//    public static List<String> lrange(String key, Integer start, Integer end) {
//        List<String> result = null;
//        if (null == key) {
//            return result;
//        }
//        try {
//            result = jedisCluster.lrange(key, start, end);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//
//    /**
//     * 该key值下的 记录总数
//     *
//     * @param key
//     * @return
//     */
//    public static Long llen(String key) {
//        Long result = null;
//        if (null == key) {
//            return result;
//        }
//        try {
//            result = jedisCluster.llen(key);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//    /**
//     * Redis TTL 命令以秒为单位返回 key 的剩余过期时间。
//     *
//     * @param key
//     * @return 当 key 不存在时，返回 -2 。 当 key 存在但没有设置剩余生存时间时，返回 -1 。 否则，以毫秒为单位，返回 key 的剩余生存时间。
//     */
//
//    public static Long ttl(String key) {
//        Long result = null;
//        if (null == key) {
//            return result;
//        }
//        try {
//            result = jedisCluster.ttl(key);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//    /**
//     * Redis Expire 命令用于设置 key 的过期时间。key 过期后将不再可用。
//     *
//     * @param key
//     * @return 设置成功返回 1 。 当 key 不存在或者不能为 key 设置过期时间时返回0
//     */
//    public static long expire(String key, int seconds) {
//        long result = 0L;
//        if (null == key) {
//            return result;
//        }
//        try {
//            result = jedisCluster.expire(key, seconds);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//    /* *
//     * Redis Keys 命令用于查找所有符合给定模式 pattern 的 key
//     *
//     * @param key
//     * @return  符合给定模式的 key 列表 (Array)。
//     * */
//
//    public static TreeSet<String> keys(String key) {
//        TreeSet<String> keys = new TreeSet<>();
//        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
//        for (String k : clusterNodes.keySet()) {
//            JedisPool jp = clusterNodes.get(k);
//            Jedis connection = jp.getResource();
//            try {
//                keys.addAll(connection.keys(key));
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            } finally {
//                connection.close();//用完一定要close这个链接！！！
//            }
//        }
//        return keys;
//    }
//
//
//    public Jedis getJedis(String key){
//        Map<String,JedisPool> nodeMap = jedisCluster.getClusterNodes();
//        String anyHost = nodeMap.keySet().iterator().next();
//        TreeMap<Long,String> slotHostMap = getSlotHostMap(anyHost);
//        int slot = JedisClusterCRC16.getSlot(key);
//        Map.Entry<Long, String> entry = slotHostMap.lowerEntry(Long.valueOf(slot));
//
//        Jedis jedis = nodeMap.get(entry.getValue()).getResource();
//        return jedis;
//    }
//
//    private static TreeMap<Long,String> getSlotHostMap(String anyHostAndPortStr){
//        TreeMap<Long, String> tree = new TreeMap<Long, String>();
//        String parts[] = anyHostAndPortStr.split(":");
//        HostAndPort anyHostAndPort = new HostAndPort(parts[0], Integer.parseInt(parts[1]));
//        try{
//            Jedis jedis = new Jedis(anyHostAndPort.getHost(), anyHostAndPort.getPort());
//            List<Object> list = jedis.clusterSlots();
//            for (Object object : list) {
//                List<Object> list1 = (List<Object>) object;
//                List<Object> master = (List<Object>) list1.get(2);
//                String hostAndPort = new String((byte[]) master.get(0)) + ":" + master.get(1);
//                tree.put((Long) list1.get(0), hostAndPort);
//                tree.put((Long) list1.get(1), hostAndPort);
//            }
//            jedis.close();
//        }catch(Exception e){
//
//        }
//        return tree;
//    }



}
