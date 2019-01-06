package com.wk.boot.shop.api.service;

import com.wk.boot.shop.api.dto.UserDto;

import java.util.List;

/**
 * Created by wgp on 2018/12/19.
 */
public interface RedisManageService {

    void setCacheUserList(List<UserDto> userList);
}
