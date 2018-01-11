package com.example.study.designpattern.singleton.枚举方式;

/**
 * 单例模式 - 枚举方式
 *  -立即加载
 *  -线程安全
 *  -实现简单
 *  -防止反序列化
 */
public enum SingletonClass {

    INSTANCE;

    public void f(){
        System.out.println("单例模式 - 枚举方式");
    }
}
