package com.wk.boot.shop.api.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by wgp on 2018/12/17.
 */
@Data
public class ThreadDto {
    private List<ClassDto> classDtoList;
    private List<UserDto> userDtoList;
    private List<TeacherDto> teacherDtoList;
    private Long time;

}
