package com.yzf.example.util;


import com.alibaba.fastjson.JSON;

/**
 * ResultUtil
 *
 * @author Administrator
 * @date 2020/1/9
 */
public class ResultUtil {

    public static String success(Object obj,String msg){
        Result result = new Result();
        result.setCode("10000");
        result.setMsg(msg);
        result.setObj(obj);
        return JSON.toJSONString(result);
    }

    public static String error(String msg){
        Result result = new Result();
        result.setCode("10001");
        result.setMsg(msg);
        result.setObj("");
        return JSON.toJSONString(result);
    }
}
