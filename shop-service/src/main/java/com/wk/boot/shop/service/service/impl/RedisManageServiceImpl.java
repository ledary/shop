package com.wk.boot.shop.service.service.impl;

import com.wk.boot.shop.api.dto.UserDto;
import com.wk.boot.shop.api.service.RedisManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wgp on 2018/12/19.
 */
@Service
public class RedisManageServiceImpl implements RedisManageService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void setCacheUserList(List<UserDto> userList) {
    }
}
