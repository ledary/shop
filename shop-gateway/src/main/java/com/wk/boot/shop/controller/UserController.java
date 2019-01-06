package com.wk.boot.shop.controller;

import com.wk.boot.shop.api.dto.UserDto;
import com.wk.boot.shop.api.result.ServiceResult;
import com.wk.boot.shop.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wgp on 2018/11/23.
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/list")
    public ServiceResult<List<UserDto>> getList(){
        return  userService.getUserList();
    }
}
