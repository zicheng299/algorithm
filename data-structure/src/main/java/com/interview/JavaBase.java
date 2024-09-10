package com.interview;

import com.interview.domain.DemoEntity;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

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

    /**
     * 重写equals方法需要重写hashCode方法
     * 如果两个对象调用equals方法相等那么调用hashcode方法也必须相等
     * equals方法原本比较的是对象的地址值，且hashcode方法返回的值是通过地址值计算出来的，所以符合条件
     * 当我们重写equals方法时，却没有重写hashcode方法时，不符合条件
     */
    @Test
    public void equalsDemo() {
        DemoEntity o1 = new DemoEntity();
        o1.setName("abc");
        DemoEntity o2 = new DemoEntity();
        o2.setName("abc");

        System.out.println(o1.equals(o2));
        //没有重写hashcode时，key=o2 不会覆盖 key=o1
        Map<DemoEntity, Integer> map = new HashMap<>(2);
        map.put(o1, 1);
        map.put(o2, 1);
        System.out.println(map.size());


    }

    /**
     * 基本类型 int short long double float char byte boolean
     * 都是值传递，不会修改原来的值
     * 他们的封装类是引用传递（除了String），但是封装类没有提供方法修改值
     */

    /**
     * 反射：在运行时，可以通过类名，获取类的信息
     *
     * 乐观锁和悲观锁
     * 悲观锁：如synchronized,采用线程独占的方式
     * 乐观锁：假设数据不会出现冲突的情况，等到数据提交的时候判断是否存在冲突，如果冲突了就返回错误信息
     */

    /**
     *
     * 多线程
     */
    @Test
    public void threadDemo() throws InterruptedException {
        //定长线程池，可以控制最大并发数
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //可缓存线程池，可以回收空闲线程
//        Executors.newCachedThreadPool();
        //单线程化的线程池，只有一个线程
        Executors.newSingleThreadExecutor();
        //定长线程池，可以周期性定时执行任务
//        Executors.newScheduledThreadPool();

        executorService.execute(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        });
        //需要等线程都执行完毕，才能看到打印结果
        Thread.sleep(1000);
    }

    @Test
    public void threadDemo1() throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //创建一个callable任务
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int x = 0;
                for (int i = 0; i < 100; i++) {
                    x += i;
                    Thread.sleep(100);
                }
                return x;
            }
        };
        //提交任务
        Future<Integer> submit = executorService.submit(callable);
        //获取结果
        Integer result = submit.get();
        System.out.println(result);

        //关闭线程池
        executorService.shutdown();
    }

    @Test
    public void threadDemo2() throws ExecutionException, InterruptedException {
        //创建一个callable 任务
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int x = 0;
                for (int i = 0; i < 100; i++) {
                    x += i;
                    Thread.sleep(100);
                }
                return x;
            }
        };
        //创建FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //提交任务
        executorService.submit(futureTask);


        //获取结果
        Integer result = futureTask.get();
        System.out.println(result);

        //关闭线程池
        executorService.shutdown();

    }
}


