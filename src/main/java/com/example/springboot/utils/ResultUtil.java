package com.example.springboot.utils;

import com.example.springboot.entity.Result;

public class ResultUtil {

    public static Result result = new Result();

    public static Result success(Object object){

        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        result.setCode(code);
        result.setMsg(msg);
        return result;

    }
}
