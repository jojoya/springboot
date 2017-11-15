package com.example.springboot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2017/11/14.
 */
@Aspect
@Component
public class HttpAspect {

    @Before("execution( * com.example.springboot.controller.CustomerController.customerList(..))")
    public void log(){
        System.out.println(111111);
    }
}
