package com.wk.boot.shop.controller;

import com.wk.boot.shop.api.dto.UserDto;
import com.wk.boot.shop.api.service.SingleRedisService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述:
 * 单机redis和集群redis测试类
 *
 * @author 武刚鹏
 * @create 2019-01-22 22:15
 */
@RequestMapping("/api/redis")
@Controller
public class RedisController {

    @Autowired
    private SingleRedisService singleRedisService;
    @GetMapping("string")
    @ResponseBody
    @ApiOperation(value = "用于测试的方法",notes = "测试单机redis的序列化与反序列化")
    public Object stringTest(){
        UserDto dto = new UserDto();
        dto.setEmail("111.com");
        dto.setId(1L);
        dto.setPassword("1212");
        dto.setUserId(1);
        return singleRedisService.setString(dto);
    }
}
