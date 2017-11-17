package com.example.springboot.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;

//    @NotNull(message = "name不能为Null")
    @NotEmpty(message = "name不能为Empty")
    @Size(min=10,max = 100, message = "name字段长度必须在10-100之间")
    private String name;

    @Min(value = 18, message = "未成年")
    @Max(value = 150,message = "非常人")
    private int age;

    //必须要有构造函数
    public Customer(){

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

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"age\":" + age +
                '}';
    }
}
