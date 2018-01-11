package com.example.study.designpattern.singleton.类加载方式;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例模式 - 类加载模式式
 *  -延迟加载
 *  -线程安全（利用了类加载的线程安全性）
 *  -同步效率高
 *  -实现简单
 *  -不能防止反序列化
 *
 * 代码实现的关键点：
 *  1）这个的类在整个JVM中有仅有一个对象实例
 *      对象的创建方式有：
 *          a)new
 *          b)反射（reflect）
 *          c)反序列化（deserialize） --不实现Serializable接口或者自定义反序列化的过程
 *          d)克隆（clone） --不实现Clonable接口或自定义克隆的过程
 *  2）提供一个访问它的全局访问点
 *          a）公开的静态变量（不利于扩展）
 *          b）一个公开的静态方法，返回唯一实例
 */
public class SingletonClass implements Serializable,Cloneable{

    //屏蔽外部的new
    private SingletonClass(){

    }

    //静态内部类，用于持有唯一的SingletonClass的示例
    private static class OnlyInstanceHolder{
        static final SingletonClass ONLY = new SingletonClass();
    }

    //创建公开唯一访问点
    public static SingletonClass getInstance(){
        return OnlyInstanceHolder.ONLY;
    }

    //自定义序列化返回的对象
    private Object readResolve() throws ObjectStreamException{
        return getInstance();
    }

    //自定义克隆返回的对象
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return getInstance();
    }

}
