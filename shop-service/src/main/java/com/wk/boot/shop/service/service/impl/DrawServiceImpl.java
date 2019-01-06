package com.wk.boot.shop.service.service.impl;

import com.wk.boot.shop.api.dto.DrawDto;
import com.wk.boot.shop.api.result.ServiceResult;
import com.wk.boot.shop.api.service.DrawService;
import com.wk.boot.shop.persistent.dao.DrawDao;
import com.wk.boot.shop.persistent.entity.DrawEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgp on 2018/12/22.
 */
@Service
public class DrawServiceImpl implements DrawService {

    @Autowired
    private DrawDao drawDao;

    @Override
    public ServiceResult<List<DrawDto>> getDrawMoney(Long userId) {
        List<DrawEntity> dbList =  drawDao.getListByUserId(userId);
        if(dbList.isEmpty()){
            return ServiceResult.returnEmpty();
        }
        List<DrawDto> resultList = new ArrayList<>(dbList.size());
        dbList.forEach(p->{
            DrawDto drawDto = new DrawDto();
            drawDto.setMoney(p.getMoney());
            drawDto.setUserId(p.getUserId());
            resultList.add(drawDto);
        });
        return  ServiceResult.returnSuccess(resultList);

    }
}
