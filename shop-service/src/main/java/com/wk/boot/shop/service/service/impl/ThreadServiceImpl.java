package com.wk.boot.shop.service.service.impl;

import com.wk.boot.shop.api.dto.ClassDto;
import com.wk.boot.shop.api.dto.TeacherDto;
import com.wk.boot.shop.api.dto.UserDto;
import com.wk.boot.shop.api.service.ThreadService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * 任务多线程
 * Created by wgp on 2018/12/17.
 */

@EnableAsync
@Service
public class ThreadServiceImpl implements ThreadService {

    @Override
    @Async
    public Future<List<UserDto>> getUserList() {
        List<UserDto> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            UserDto userDto = new UserDto();
            userDto.setId(Long.valueOf(i));
            userDto.setTaskId(i);
            userDto.setUserName("wgp");
            userDto.setPassword("hcy");
            list.add(userDto);
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AsyncResult<>(list);

    }

    @Override
    @Async
    public Future<List<ClassDto>> getClassList() {
        List<ClassDto> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            ClassDto classDto = new ClassDto();
            classDto.setId(Long.valueOf(i));
            classDto.setTaskId(i);
            classDto.setTaskName("任务执行类" + i);
            list.add(classDto);
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AsyncResult<>(list);
    }

    @Override
    @Async
    public Future<List<TeacherDto>> getTeacherList() {
        List<TeacherDto> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            TeacherDto teacherDto = new TeacherDto();
            teacherDto.setId(Long.valueOf(i));
            teacherDto.setTeacherId(i);
            teacherDto.setTeacherName("任务执行类" + i);
            list.add(teacherDto);
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        //TODO java8特性处理多线程
//        CompletableFuture<ServiceResult<List<UserDto>>> completableFutureConstellation= CompletableFuture.supplyAsync(()->{
//            ServiceResult<List<UserDto>> constellation;
//                constellation= userService.getUserList(list);
//            return constellation;
//        });
        return new AsyncResult<>(list);
    }

    @Override
    public List<UserDto> getNormalUserList() {
        List<UserDto> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            UserDto userDto = new UserDto();
            userDto.setId(Long.valueOf(i));
            userDto.setTaskId(i);
            userDto.setUserName("wgp");
            userDto.setPassword("hcy");
            list.add(userDto);
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ClassDto> getNormalClassList() {
        List<ClassDto> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            ClassDto classDto = new ClassDto();
            classDto.setId(Long.valueOf(i));
            classDto.setTaskId(i);
            classDto.setTaskName("任务执行类" + i);
            list.add(classDto);
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TeacherDto> getNormalTeacherList() {
        List<TeacherDto> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            TeacherDto teacherDto = new TeacherDto();
            teacherDto.setId(Long.valueOf(i));
            teacherDto.setTeacherId(i);
            teacherDto.setTeacherName("任务执行类" + i);
            list.add(teacherDto);
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;

    }
}
