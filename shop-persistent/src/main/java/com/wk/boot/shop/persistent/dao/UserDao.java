package com.wk.boot.shop.persistent.dao;

import com.wk.boot.shop.persistent.entity.UserEntity;

import java.util.List;

/**
 * Created by wgp on 2018/11/22.
 */
public interface UserDao {

    List<UserEntity> getList();
}
