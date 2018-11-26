package com.wk.boot.shop.api.service;

import com.wk.boot.shop.api.param.PersonCommonParam;
import com.wk.boot.shop.api.result.ServiceResult;
import com.wk.boot.shop.common.dto.DimensionDto;

import java.util.List;

/**
 * Created by wgp on 2018/11/26.
 */
public interface PersonCommonService {


    ServiceResult<List<DimensionDto>> getCountByDimension(PersonCommonParam param);

}
