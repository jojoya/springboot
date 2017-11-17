package com.example.springboot.handle;

import com.example.springboot.entity.Result;
import com.example.springboot.exception.CustomerException;
import com.example.springboot.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by user on 2017/11/17.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof CustomerException){
            CustomerException customerException = (CustomerException) e;
            return ResultUtil.error(customerException.getCode(),customerException.getMessage());
        }else {
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1, "未知错误！");
        }
    }
}
