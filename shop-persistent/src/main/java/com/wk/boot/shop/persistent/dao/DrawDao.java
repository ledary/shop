package com.wk.boot.shop.persistent.dao;

import com.wk.boot.shop.persistent.entity.DrawEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wgp on 2018/12/22.
 */
@Mapper
public interface DrawDao {

    List<DrawEntity> getList();
    List<DrawEntity> getListByUserId(Long userId);

}
