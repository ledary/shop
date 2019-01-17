package com.wk.boot.shop.common.utils;

import java.io.IOException;
import java.net.Socket;

/**
 * 模拟Jedis 操作工具类
 * Created by wgp on 2018/12/24.
 */
public class RedisSocket {

    private Socket socket;
    public RedisSocket(){
        try{
            this.socket = new Socket("127.0.0.1",6379);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }

    public String get(String key)throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*2").append("\r\n");
        stringBuilder.append("$3").append("\r\n");
        stringBuilder.append("GET").append("\r\n");
        stringBuilder.append("$").append(key.length()).append("\r\n");
        stringBuilder.append(key).append("\r\n");
        socket.getOutputStream().write(stringBuilder.toString().getBytes());
        byte[] b = new byte[2048];
        socket.getInputStream().read(b);
        return new String(b);

    }

    public String set(String key,String value)throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*3").append("\r\n");
        stringBuilder.append("$3").append("\r\n");
        stringBuilder.append("SET").append("\r\n");
        stringBuilder.append("$").append(key.length()).append("\r\n");
        stringBuilder.append(key).append("\r\n");
        stringBuilder.append("$").append(value.length()).append("\r\n");
        stringBuilder.append(value).append("\r\n");
       socket.getOutputStream().write(stringBuilder.toString().getBytes());
        byte[] b =new byte[2048];
        socket.getInputStream().read(b);
        return new String(b);
    }

    public static void main(String[] args)throws Exception {
        RedisSocket socket = new RedisSocket();
        System.out.println(socket.set("hello","2019"));
        System.out.println(socket.get("hello"));
    }
}
