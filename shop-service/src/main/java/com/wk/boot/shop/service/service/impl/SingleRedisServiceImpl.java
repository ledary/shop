package com.wk.boot.shop.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.wk.boot.shop.api.dto.UserDto;
import com.wk.boot.shop.api.result.ServiceResult;
import com.wk.boot.shop.api.service.SingleRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 单机版redis实现
 *
 * @author 武刚鹏
 * @create 2019-01-22 22:08
 */
@Service
public class SingleRedisServiceImpl implements SingleRedisService {

    @Autowired
    private RedisTemplate stringRedisTemplate;

    @Override
    public ServiceResult<Object> setString(UserDto userDto) {
//        String str = JSON.toJSONString(userDto);
//        stringRedisTemplate.opsForValue().set("zz",str);
        String user = (String)stringRedisTemplate.opsForValue().get("zz");
        UserDto userDto1 = JSON.parseObject(user,UserDto.class);
        return ServiceResult.returnSuccess(userDto1);
    }
}
