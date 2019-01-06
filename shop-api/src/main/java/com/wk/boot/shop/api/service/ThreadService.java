package com.wk.boot.shop.api.service;

import com.wk.boot.shop.api.dto.ClassDto;
import com.wk.boot.shop.api.dto.TeacherDto;
import com.wk.boot.shop.api.dto.UserDto;

import java.util.List;
import java.util.concurrent.Future;

/**
 * 测试多线程的任务类
 * Created by wgp on 2018/12/17.
 */
public interface ThreadService {

    Future<List<UserDto>> getUserList();
    Future<List<ClassDto>> getClassList();
    Future<List<TeacherDto>> getTeacherList();

    List<UserDto> getNormalUserList();
    List<ClassDto> getNormalClassList();
    List<TeacherDto> getNormalTeacherList();



}
