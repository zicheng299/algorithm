package com.demo.domain;

public class Stack {


    private Object[] stack;

    public Object[] getStack(){
        return stack;
    }
    //栈顶标记
    private int top = -1;
    //栈的容量
    private int size;
    //无参构造方法
    public Stack() {
        this.size = 10;
        stack = new Object[10];
    }

    public Stack(int size) {
        this.size = size;
        stack = new Object[size];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == (this.size - 1);
    }

    //入栈
    public void push(Object obj){
        if(isFull()){
            System.out.println("栈已满");
        }
        stack[++top] = obj;
    }

    //出栈 删除并返回栈顶元素
    public Object pop(){
        if (isEmpty())
            System.out.println("栈为空");
        return stack[top--];
    }

    //获取栈顶元素
    public Object getTop(){
        return stack[top];
    }

    //打印栈内元素
    public void display(){
        if(isEmpty()){
            System.out.println("[]");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.println("[" + stack[i] + "]");
        }
    }

    public int getSize(){
        return size;
    }

    public int getLength(){
        return ++top;
    }
}
