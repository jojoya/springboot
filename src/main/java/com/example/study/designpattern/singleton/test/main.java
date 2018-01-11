package com.example.study.designpattern.singleton.test;

//import com.example.study.designpattern.singleton.饿汉式.SingletonClass;
//import com.example.study.designpattern.singleton.懒汉式.SingletonClass;

import com.example.study.designpattern.singleton.枚举方式.SingletonClass;

/**
 * Created by user on 2018/1/10.
 */
public class main {
    public static void main(String [] args){
       /* SingletonClass a = SingletonClass.getInstance();
        SingletonClass b = SingletonClass.getInstance();
        System.out.println(a==b);*/

        SingletonClass.INSTANCE.f();
    }
}
