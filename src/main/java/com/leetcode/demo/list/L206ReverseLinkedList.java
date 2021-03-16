package com.leetcode.demo.list;

import com.leetcode.entity.ListNode;

public class L206ReverseLinkedList {
    // 1
    // 1<-2
    // 1<-2<-3
    // 1<-2<-3<-4
    // 1<-2<-3<-4<-5
    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        ListNode curr = head;
        while (curr != null) {
            // 下一个
            ListNode nextTem = curr.next;
            // 当前节点指向新的链表
            curr.next = newNode;
            // 新节点就是当前节点且在最前面
            newNode = curr;
            // ++
            curr = nextTem;
        }
        return newNode;
    }

}