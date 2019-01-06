package com.wk.boot.shop.api.service;

import com.wk.boot.shop.api.dto.DrawDto;
import com.wk.boot.shop.api.result.ServiceResult;

import java.util.List;

/**
 * 红包服务类
 * Created by wgp on 2018/12/22.
 */
public interface DrawService {
    ServiceResult<List<DrawDto>> getDrawMoney(Long userId);
}
