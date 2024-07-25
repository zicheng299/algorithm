package com.demo.domain;

public class ListNode {

    public ListNode() {
    }

    public int val; // 节点的保存的内容
    public ListNode next = null;  //节点的引用，指向下一节点

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
