package com.interview;

import org.junit.Test;

public class JavaBase {


    /**
     * 面向对象的三个特征：封装、继承、多态
     * 优点：低耦合（易维护、易复用、易扩展）
     *
     * 多态：
     * 1.父类参数可以接收子类对象
     * 2.接口实现：父类接口引用指向子类对象
     * 3.继承：子类重写父类方法
     */

    /**
     * finally中的return会覆盖掉try和catch里面的return
     */
    @Test
    public void tryCatch() {
        System.out.println(tryReturn());
    }

    private String tryReturn() {
        try {
            int i = 1 / 0;
            return "try";
        } catch (Exception e) {
            return "catch";
        } finally {
//            return "finally";
        }
    }

    /**
     * String : 字符串常量，不可变
     * StringBuilder ： 非线程安全
     * StringBuffer：线程安全
     */
    @Test
    public void StringTest() {
        String string = "1";
        stringConcat(string);
        System.out.println("String 字符串常量，不可变 : " + string);


    }

    private void stringConcat(String val) {
        val += "2";
    }
}


