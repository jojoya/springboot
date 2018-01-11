package com.example.study.serializer;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by user on 2018/1/4.
 */
public class User {
    // 配置序列化的时候,不序列化id
    @JSONField(serialize=false)
    private int id;

    private String name; // 姓名
    private int age; // 年龄
    private Date date;

    // 配置序列化的名称
    @JSONField(name="gender")
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
