package com.wk.boot.shop.api.service;

import com.wk.boot.shop.api.dto.UserDto;
import com.wk.boot.shop.api.result.ServiceResult;

import java.util.List;

/**
 * Created by wgp on 2018/11/23.
 */
public interface UserService {

    ServiceResult<List<UserDto>> getUserList();
}
