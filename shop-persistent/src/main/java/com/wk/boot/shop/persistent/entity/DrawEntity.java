package com.wk.boot.shop.persistent.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by wgp on 2018/12/22.
 */
@Data
public class DrawEntity extends BaseEntity {
    private Long userId;
    private BigDecimal money;
}
