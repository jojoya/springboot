package com.example.springboot.enums;

/**
 * Created by user on 2017/11/17.
 */
public enum CustomerAgeResultEnum {
    UNKNOW_ERROR(-1,"未知错误！"),
    SUCCESS(1,"成功"),
    PRIMARY_SCHOOL(100, "嗨，小学生！"),
    MIDDLE_SCHOOL(101, "嗨，中学生！"),
    SOCIAL_MAN(102, "嗨，社会人！"),
    ;

    private Integer code;
    private String message;

    CustomerAgeResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
