package com.wk.boot.shop.controller;

import com.wk.boot.shop.api.service.DrawService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgp on 2018/12/22.
 */
@RestController
@RequestMapping("/api/draw")
public class DrawController {

    @Autowired
    private DrawService drawService;

    @ApiOperation(value = "查询该用户的红包")
    @GetMapping("/getDrawMoneey")
    public Object getDrawMoney(Long userId){
        return drawService.getDrawMoney(userId);
    }
}
