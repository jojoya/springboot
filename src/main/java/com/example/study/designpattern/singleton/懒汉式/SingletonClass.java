package com.example.study.designpattern.singleton.懒汉式;

/**
 * 单例模式 - 懒汉式
 *  -延时创建
 *  -线程安全问题（需要加锁）
 *  -同步情况下效率问题（需要双重验证）
 */
public class SingletonClass {

//    创建唯一的实例
    private static SingletonClass ONLY;

//    屏蔽外部的new
    private SingletonClass(){

    }

//    创建一个全局的访问点
    public  static SingletonClass getInstance(){

        //双重验证
        if(ONLY==null){
            synchronized(SingletonClass.class) {  //加锁
                if(ONLY==null) {
                    ONLY = new SingletonClass();
                }
            }
        }

        return ONLY;
    }

}
