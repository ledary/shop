package com.wk.boot.shop.persistent.entity;

import lombok.Data;

/**
 * Created by wgp on 2018/11/22.
 */
@Data
public class UserEntity extends BaseEntity {

    private String userName;
    private String password;
    private String email;
}
