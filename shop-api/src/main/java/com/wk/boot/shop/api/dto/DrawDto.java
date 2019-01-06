package com.wk.boot.shop.api.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by wgp on 2018/12/22.
 */
@Data
public class DrawDto {
    private Long userId;
    private BigDecimal money;
}
