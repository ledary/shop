package com.wk.boot.shop.api.result;

import com.wk.boot.shop.common.constants.Constants;
import lombok.Data;

/**
 * Created by wgp on 2018/11/23.
 */
@Data
public class ServiceResult<T> {

    private Integer code;
    private String message;
    private T body;

    public ServiceResult(Integer code,String msg,T body){
        this.code = code;
        this.message = msg;
        this.body = body;
    }

    public static <T> ServiceResult returnSuccess(T body){
        return new ServiceResult(Constants.successCode,Constants.successMsg,body);
    }

    public static <T> ServiceResult returnEmpty(){
       return new ServiceResult(Constants.successCode,Constants.successMsg,new Object());
    }
}
