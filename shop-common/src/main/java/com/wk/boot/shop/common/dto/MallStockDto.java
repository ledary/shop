package com.wk.boot.shop.common.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述:
 * 库存记录
 *
 * @author 武刚鹏
 * @create 2019-01-09 22:17
 */
@Data
public class MallStockDto {
    private Integer skuId;
    private Integer warehouseId;
    private Integer ownerId;
    private BigDecimal stockNum;
    private BigDecimal holdNum;
    private Integer controlType;

    public String getKey(){
        return this.skuId + "_" + this.warehouseId + "_" + this.ownerId + "{" + this.warehouseId + "}";
    }


}
