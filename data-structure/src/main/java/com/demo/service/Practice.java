package com.demo.service;

import com.demo.domain.Stack;
import org.junit.Test;

public class Practice {


    /**
     * 输出九九乘法表
     */
    @Test
    public void MultiplicationTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (j * i) + " ");
            }
            System.out.println();
        }

    }

    /**
     * 计算阶乘 1+2！+3！+。。。。+20！
     */
    @Test
    public void factAdd() {

        int result = 0;
        for (int i = 1; i <= 20; i++) {
            result += fact(i);
        }
        System.out.println(result);

    }

    /**
     * 阶乘
     *
     * @param n
     * @return
     */
    static int fact(int n) {
        if (n == 1) {
            System.out.println(1);
            return 1;
        }
        System.out.print(n);
        n *= fact(n - 1);
        return n;
    }

    /**
     * 设计一个栈，实现pop push top size等功能
     */
    @Test
    public void myStack(){
        Stack stack = new Stack(5);
        //进栈
        stack.push(1);
        stack.display();
        //出栈
        stack.pop();
        stack.display();
        stack.push(2);
        stack.display();
        //获取栈顶元素
        stack.push(6);
        stack.pop();
        stack.display();
        System.out.println(stack.getTop());

        //创建一个数组,长度为10
//        int[] arr = new int[10];
//        int top = -1;
//        //进栈
//        arr[++top] = 1;
//        arr[++top] = 2;
//        System.out.println(Arrays.toString(arr));
//        //出栈,并打印栈顶元素
//        top--;
//        System.out.println(arr[top]);

    }
}
