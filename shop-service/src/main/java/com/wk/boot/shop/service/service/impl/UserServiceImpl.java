package com.wk.boot.shop.service.service.impl;

import com.wk.boot.shop.api.dto.UserDto;
import com.wk.boot.shop.api.result.ServiceResult;
import com.wk.boot.shop.api.service.UserService;
import com.wk.boot.shop.persistent.dao.UserDao;
import com.wk.boot.shop.persistent.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgp on 2018/11/23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ServiceResult<List<UserDto>> getUserList() {
        List<UserEntity> userEntityList = userDao.getList();
        if(CollectionUtils.isEmpty(userEntityList)){
            return ServiceResult.returnSuccess(new ArrayList<>());
        }
        List<UserDto> userDtoList = new ArrayList<>(userEntityList.size());
        for (UserEntity userEntity:userEntityList) {
            UserDto userDto = new UserDto();
            userDto.setEmail(userEntity.getEmail());
            userDto.setUserName(userEntity.getUserName());
            userDto.setPassword(userEntity.getPassword());
            userDtoList.add(userDto);
        }
        return ServiceResult.returnSuccess(userDtoList);
    }
}
