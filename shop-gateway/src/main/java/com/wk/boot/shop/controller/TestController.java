package com.wk.boot.shop.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgp on 2018/11/22.
 */
@RestController
@RequestMapping("api/boot/shop/test")
public class TestController {

    @ApiOperation(value = "用于测试的方法",notes = "获取测试信息")
    @GetMapping("/test0")
    public Object test0(){
        return "用于测试";
    }
}
