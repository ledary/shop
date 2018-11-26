package com.wk.boot.shop.service.service.impl;

import com.wk.boot.shop.api.service.DimensionService;
import com.wk.boot.shop.common.dto.DimensionDto;
import com.wk.boot.shop.common.enums.PersonCommonEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgp on 2018/11/26.
 */
@Service
public class DimensionServiceImpl implements DimensionService {
    @Override
    public List<DimensionDto> getDimension() {
        PersonCommonEnum[] enums = PersonCommonEnum.values();
        if(enums == null && enums.length==0){
            return  new ArrayList<>();
        }
        List<DimensionDto> resultList = new ArrayList<>();
        for (PersonCommonEnum personCommonEnum:enums) {
            DimensionDto dto = new DimensionDto();
            dto.setCloumns(personCommonEnum.getColumns());
            dto.setDesc(personCommonEnum.getDesc());
            dto.setCode(personCommonEnum.getCode());
            resultList.add(dto);
        }
        return resultList;
    }
}
