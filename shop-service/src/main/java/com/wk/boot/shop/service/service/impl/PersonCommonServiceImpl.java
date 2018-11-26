package com.wk.boot.shop.service.service.impl;

import com.wk.boot.shop.api.param.PersonCommonParam;
import com.wk.boot.shop.api.result.ServiceResult;
import com.wk.boot.shop.api.service.DimensionService;
import com.wk.boot.shop.api.service.PersonCommonService;
import com.wk.boot.shop.common.dto.DimensionDto;
import com.wk.boot.shop.persistent.dao.PersonCommonDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgp on 2018/11/26.
 */
@Service
public class PersonCommonServiceImpl implements PersonCommonService {

    @Autowired
    private PersonCommonDao personCommonDao;

    @Autowired
    private DimensionService dimensionService;
    @Override
    public ServiceResult<List<DimensionDto>> getCountByDimension(PersonCommonParam param) {
        List<DimensionDto> paramList = new ArrayList<>();
        //1、这块就比较繁琐了，需要构造16个维度的实体。
        // 可以考虑通过方法去构建，设置考虑通过建造者或者职责连去做
        //或者可以考虑做模板，把维度做成持久化
        List<DimensionDto> dimensionDtoList = dimensionService.getDimension();
       dimensionDtoList.forEach(p->{
           BeanUtils.copyProperties(param,p);
       });
       List<DimensionDto> resultList = personCommonDao.getCountByDimension(dimensionDtoList);
       return ServiceResult.returnSuccess(resultList);

    }

}
