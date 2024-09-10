package com.interview.singleExample;

/**
 * 单例模式之双重检定
 * 优点：获取实例方法没有加锁；支持延时加载
 *
 */
public class SingletonDouble {

    //私有静态变量，唯一实例
    private static SingletonDouble instance;

    //私有无参构造方法
    private SingletonDouble(){}

    //公开静态获取方法
    public static SingletonDouble getInstance(){
        //第一重检定，对类进行加锁
        if (instance == null){
            synchronized (SingletonDouble.class){
                //第二重检定，防止多线程并发时重复创建对象
                if (instance == null){
                    instance = new SingletonDouble();
                }
            }
        }
        return instance;
    }
}
