package com.wk.boot.shop.api.dto;


import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * Created by wgp on 2018/11/25.
 */
@Data
public class TeacherDto {

    private String uuid;
    private UserDto userDto;


    public static void main(String[] args) {
        TeacherDto teacherDto = new TeacherDto();
        UserDto userDto = new UserDto();
        userDto.setPassword("232323");
        userDto.setUserName("某某某");
        userDto.setEmail("122@com");
        teacherDto.setUserDto(userDto);
        teacherDto.setUuid("121212");

        String jsonStr = JSON.toJSONString(teacherDto);
        System.out.println(jsonStr);
    }
}
