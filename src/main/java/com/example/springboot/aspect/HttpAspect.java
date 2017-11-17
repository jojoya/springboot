package com.example.springboot.aspect;

import com.example.springboot.entity.Result;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;


/**
 * Created by user on 2017/11/14.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.springboot.controller.CustomerController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        logger.info("---Before---");
        // 请求参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // 请求对象
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //方法名
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("GET:args ={}", joinPoint.getArgs());

    }

    @After("log()")
    public void doAfter(){
        logger.info("---After---");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Result result){
        logger.info("response{}",result.toString());
    }
}
