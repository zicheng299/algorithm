package com.interview.singleExample;

/**
 * 单例模式之懒汉式
 * 优点：延时加载，第一次获取实例的时候才创建实例
 * 缺点：获取对象的方法加锁，只是第一次调用的时候有用
 */
public class SingletonLazy {

    //私有静态变量，存储唯一实例
    private static SingletonLazy instance;

    //私有无参构造方法
    private SingletonLazy() {
    }

    //公开静态方法，获取实例
    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

}
