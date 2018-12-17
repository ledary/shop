package com.wk.boot.shop.service.service.task;

import com.wk.boot.shop.api.dto.ClassDto;
import com.wk.boot.shop.api.dto.TeacherDto;
import com.wk.boot.shop.api.dto.ThreadDto;
import com.wk.boot.shop.api.dto.UserDto;
import com.wk.boot.shop.api.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by wgp on 2018/12/17.
 */
@Component
public class ThreadTask {

    @Autowired
    private ThreadService threadService;


    public ThreadDto getAsyncCombinationDto(){
        long start = System.currentTimeMillis();
        ThreadDto dto = new ThreadDto();
        Future<List<ClassDto>> task1 = threadService.getClassList();
        Future<List<TeacherDto>> task2 = threadService.getTeacherList();
        Future<List<UserDto>> task3 = threadService.getUserList();
        // 回调函数 Future,等待任务执行完毕
        for (;;) {
            if (task1.isDone()) {
                System.out.println("task1");
                break;
            }
        }
        try{
            dto.setClassDtoList(task1.get());
            dto.setTeacherDtoList(task2.get());
            dto.setUserDtoList(task3.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        dto.setTime(end-start);
        return  dto;
    }

    /**
     * 串行执行任务，获取数据
     * @return
     */
    public ThreadDto getCombinationDto(){
        //任务开始执行
        long start = System.currentTimeMillis();
        ThreadDto dto = new ThreadDto();
        //赋值数据
        try{
            dto.setClassDtoList(threadService.getNormalClassList());
            dto.setTeacherDtoList(threadService.getNormalTeacherList());
            dto.setUserDtoList(threadService.getNormalUserList());
        }catch (Exception e){
            e.printStackTrace();
        }
        //打印执行时间
        long end = System.currentTimeMillis();
        dto.setTime(end-start);
        return  dto;
    }
}
