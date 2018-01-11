package com.example.study.serializer;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 测试用的实体类
 * 使用@JSONType配置只序列化name,sex字段
 */

@JSONType(includes={"name", "sex"})
public class Uo1 implements Serializable {

    private int id;

    private String name; // 姓名
    private int age; // 年龄
    private Date date;
    private String sex;












    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
