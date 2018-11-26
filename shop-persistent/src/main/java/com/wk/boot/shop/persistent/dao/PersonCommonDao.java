package com.wk.boot.shop.persistent.dao;

import com.wk.boot.shop.common.dto.DimensionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wgp on 2018/11/26.
 */
@Mapper
public interface PersonCommonDao {

    List<DimensionDto> getCountByDimension(List<DimensionDto> paramList);
}
