package com.wk.boot.shop.common.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * 描述:
 * redisBean
 *
 * @author 武刚鹏
 * @create 2019-01-22 22:25
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {





    @Bean
    public RedisTemplate<String,String> redisTemplate (RedisConnectionFactory factory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(factory);
        //设置序列化工具
//        setSerializer(stringRedisTemplate);
        stringRedisTemplate.afterPropertiesSet();
        return stringRedisTemplate;
    }


    private void setSerializer(StringRedisTemplate template){
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
    }

}
