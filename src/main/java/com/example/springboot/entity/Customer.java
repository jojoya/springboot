package com.example.springboot.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer extends BaseEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int id;
    @Min(value = 18, message = "未成年")
    @Max(value = 150,message = "非常人")
    private int age;

//    @NotNull(message = "name不能为Null")
//    @NotEmpty(message = "name不能为Empty")
    @NotBlank(message = "name不能为Blank")
    @Size(min=10,max = 100, message = "name字段长度必须在10-100之间")
    private String name;



    //必须要有构造函数
    public Customer(){

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + serialVersionUID +
                ", \"name\":\"" + name + '\"' +
                ", \"age\":" + age +
                '}';
    }
}
