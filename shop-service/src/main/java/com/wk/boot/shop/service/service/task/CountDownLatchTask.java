package com.wk.boot.shop.service.service.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * 描述:
 * 多线程计数
 *
 * @author 武刚鹏
 * @create 2019-01-17 23:49
 */
public class CountDownLatchTask {

    private final static Logger logger = LoggerFactory.getLogger(CountDownLatchTask.class);

    public static void main(String[] args)throws Exception {
        int num = 5;
        int total = 1000;
        int size = total/5;
        CountDownLatch countDownLatch = new CountDownLatch(num);
        for(int i=0; i<num; i++){
            final int startIndex = i* size;
            new Thread(()->{
                new CountDownLatchTask().test(startIndex,size);
                countDownLatch.countDown();
            }).start();
//            countDownLatch.countDown();
        }
        System.out.println("主线程阻塞,等待所有子线程执行完成");
        //endLatch.await()使得主线程（main）阻塞直到endLatch.countDown()为零才继续执行
        countDownLatch.await();
        System.out.println("所有线程执行完成!");
    }

    public void test(int startIndex,int size){

        logger.info("执行发短信第{}条到{}条",startIndex,startIndex+size);
    }
}
