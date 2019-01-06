package com.wk.boot.shop.api.dto;

import lombok.Data;

/**
 * Created by wgp on 2018/11/23.
 */
@Data
public class UserDto {
    private Long id;
    private Integer taskId;
    private Integer userId;
    private String userName;
    private String password;
    private String email;
}
