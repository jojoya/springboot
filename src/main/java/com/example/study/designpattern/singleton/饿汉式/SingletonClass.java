package com.example.study.designpattern.singleton.饿汉式;

/**
 * 单例模式 - 饿汉式
 *  -立即创建
 *  -线程安全
 */
public class SingletonClass {

//    创建唯一的实例
    private static final SingletonClass ONLY = new SingletonClass();

//    屏蔽外部的new
    private SingletonClass(){

    }

//    创建一个全局的访问点
    public static SingletonClass getInstance(){

        return ONLY;
    }

    public void f(){
        System.out.println("单例模式 - 饿汉式");
    }
}
