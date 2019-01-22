package com.wk.boot.shop.api.service;

import com.wk.boot.shop.api.dto.UserDto;
import com.wk.boot.shop.api.result.ServiceResult;

/**
 * 描述:
 * 单机版Redis实现
 *
 * @author 武刚鹏
 * @create 2019-01-22 22:09
 */
public interface SingleRedisService  {


    ServiceResult setString(UserDto userDto);
}
