package com.wk.boot.shop.controller;

import com.wk.boot.shop.service.service.task.ThreadTask;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgp on 2018/12/17.
 */
@RestController
@RequestMapping("/api/thread")
public class ThreadController {

    @Autowired
    private ThreadTask threadTask;

    @ApiOperation(value = "多任务并行处理")
    @GetMapping("/test0")
    public Object test0(){
        return threadTask.getAsyncCombinationDto();
    }


    @ApiOperation(value = "多任务串行处理")
    @GetMapping("/test1")
    public Object test1(){
        return threadTask.getCombinationDto();
    }
}
