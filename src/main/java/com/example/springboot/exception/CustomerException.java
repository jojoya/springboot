package com.example.springboot.exception;

import com.example.springboot.enums.CustomerAgeResultEnum;

/**
 * Created by user on 2017/11/17.
 */
public class CustomerException extends RuntimeException {
    private Integer code;

    public CustomerException(CustomerAgeResultEnum customerAgeResultEnum){
        super(customerAgeResultEnum.getMessage());
        this.code = customerAgeResultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
