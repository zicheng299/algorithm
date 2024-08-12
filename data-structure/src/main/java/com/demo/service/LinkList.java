package com.demo.service;

import com.demo.domain.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LinkList {


    @Test
    public void initData() {
        //创建首节点
        ListNode head = new ListNode(-1);
        //创建一个变量，在移动过程中指向当前节点
        ListNode nextNode = head;
        //创建链表
        for (int i = 0; i < 10; i++) {
            //创建对象
            ListNode node = new ListNode(i);
            //当前节点的next指向新对象（current:head  next:node）
            nextNode.next = node;
            //节点移动到新对象 （current:node  next:null）
            nextNode = nextNode.next;
        }

        print(head);


    }

    @Test
    public void test() {
        ListNode node = listNodeOf(Arrays.asList(1, 2, 3, 4, 5));
        print(node);
//      deleteDuplicates(node);
//      System.out.println("删除重复节点");
//      print(node);

//      node = reverseList(node);
//      System.out.println("反转节点");
//      print(node);

//      node = reverseBetween(node, 2, 3);
//      System.out.println("反转节点，指定2到3");
//      print(node);

//      ListNode node1 = listNodeOf(Arrays.asList(6, 7, 8));
//      ListNode node2 = mergeTwoLists(node1, node);
//      System.out.println("合并两个链表");
//      print(node2);

//      node = middleNode(node);
//      System.out.println("找出链表的中点");
//      print(node);

//        reorderList(node);
//        System.out.println("重排链表");
//        print(node);

        System.out.println("删除倒数第n个节点");
        removeNthFromEnd(node,2);



    }

    //打印输出方法
    static void print(ListNode listNode) {
        //创建链表节点
        while (listNode != null) {
            System.out.println("节点:" + listNode.val);
            listNode = listNode.next;
        }
    }

    //创建随机链表
    static ListNode listNodeOf(List<Integer> list) {
        ListNode head = new ListNode(list.get(0));
        //移动指针
        ListNode nextNode = head;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0)
                continue;
            ListNode node = new ListNode(list.get(i));
            nextNode.next = node;
            nextNode = nextNode.next;
        }
        return head;
    }

    //删除链表中的重复元素
    public ListNode deleteDuplicates(ListNode listNode) {
        //创建指针
        ListNode p = listNode;
        while (p != null) {
            if (p.next != null && p.val == p.next.val) {
                //链表跳过删除对象，0 -> del -> 1 ==> 0 -> 1
                p.next = p.next.next;
            }
            //移动指针
            p = p.next;
        }
        return listNode;

    }

    /**
     * 反转链表
     * （1）-> (2) -> (3)
     * 初始化 prev = null
     * 1: (1) -> null 且 perv = (1)
     * 2: (2) -> (1)  且 prev = (2)
     */
    public ListNode reverseList(ListNode head) {
        //上一个节点
        ListNode prev = null;
        //当前节点（移动指针）
        ListNode p = head;

        while (p != null) {
            //下一节点
            ListNode temp = p.next;
            //当前节点 反转（next -> prev）
            p.next = prev;
            //更新prev
            prev = p;
            //指针移动下一节点
            p = temp;
        }

        return prev;


    }

    //反转从位置  m  到  n  的链表
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p = head;
        //排序号从1开始，到第2个数
        for (int i = 1; i < m - 1; i++) {
            p = p.next;
        }
        //需要反转的第一个数：p.next 2->3->5
        //反转
        ListNode prev = null;
        ListNode cur = p.next;
        for (int i = m; i <= n; i++) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        //p.next 2->null, prev: 3->2->null
        p.next.next = cur; // 3->2->5
        p.next = prev;//2->3->2->5

        return p;
    }

    /**
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode p = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return newNode.next;
    }

    //链表的中点
    public ListNode middleNode(ListNode head) {
        ListNode s1 = head;
        ListNode s2 = head;
        //链表的终点是null
        while (s2 != null && s2.next != null) {
            //快指针s2的速度是慢指针s1的两倍
            s1 = s1.next;
            s2 = s2.next.next;
        }
        return s1;
    }

    //重排链表 1，2，3，4，5 ==> 1,5,2,4,3
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        //找出中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2 = slow.next;

        //l2 = 4,5 进行反转
        ListNode prev = null;
        ListNode cur = l2; //当前节点
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev; //反转
            prev = cur; //更新prev
            cur = next; //移动指针
        }
        //head = 1,2,3
        slow.next = null;
        //重排
        ListNode n1 = head;
        ListNode n2 = prev;//5,4
        while (n1 != null && n2 != null) {
            ListNode temp = n2.next;
            //5->2->3
            n2.next = n1.next;
            //1->5->2->3(把5插进head)
            n1.next = n2;
            //移动指针
            n1 = n2.next;//2->3
            n2 = temp;//4
        }


    }

    //回文链表 123321或者12321
    @Test
    public void isPalindrome() {
        ListNode node = listNodeOf(Arrays.asList(1, 2, 3, 3, 2, 1));
        ListNode slow = node, fast = node, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            //prev = 1,2,3的反转
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        //元素个数为单情况下，prev = 2，1
        if (fast != null) {
            slow = slow.next;
        }
        //slow = prev
        while (slow != null) {
            if (slow.val != prev.val)
                System.out.println(false);
            slow = slow.next;
            prev = prev.next;
        }
        System.out.println("结束");
    }


    @Test
    public void testCycle(){
        //环状链表起点
        ListNode n6 = new ListNode(6);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        n6.setNext(n3);

        ListNode node = detectCycle(n1);
        System.out.println(node);
    }


    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            /**
             * 1->2->3->4->5->6->2
             * 假设z为入环点，x为慢指针速度，y为相遇时的链表序号,可列方程
             * (x > z)
             * 2x-6+z = y
             * x = y
             * 可得 x + z = 6,所以当慢指针再次走到链表终点（入环点）时，经过的路程刚好等于起点到入环点的距离
             */
            //快指针与慢指针相遇
            if(slow == fast){
                ListNode target = head;
                //慢指针到达终点，新指针到达入环点
                while (target != slow){
                    target = target.next;
                    slow = slow.next;
                }
                return target;
            }
        }
        return null;
    }

    //删除倒数第n个节点
    public void removeNthFromEnd(ListNode head, int n) {

        ListNode n1 = head;
        ListNode n2 = head;
        //缩进 n + 1
        while (n >= 0){
            n1 = n1.next;
            n--;
        }
        while (n1 != null){
            n2 = n2.next;
            n1 = n1.next;
        }
        //n2.next 此时为倒数第n个节点。删除
        n2.next = n2.next.next;
        print(head);


    }
}
