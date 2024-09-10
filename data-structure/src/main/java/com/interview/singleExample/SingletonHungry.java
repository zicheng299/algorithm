package com.interview.singleExample;

/**
 * 单例模式之饿汉式
 * 优点：创建对象是线程安全的；获取单例对象不需要加锁
 * 缺点：单例对象的创建不是延时加载
 */
public class SingletonHungry {
    //类加载的时候创建并初始化实例（私有的静态变量，存储唯一实例）
    private static final SingletonHungry instance = new SingletonHungry();

    //私有无参构造方法
    private SingletonHungry() {
    }

    //公开的静态方法
    public static SingletonHungry getInstance() {
        return instance;
    }


}
