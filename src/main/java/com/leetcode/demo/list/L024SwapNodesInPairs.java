package com.leetcode.demo.list;

import com.leetcode.entity.ListNode;

public class L024SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode tem = node;
        while (tem.next != null && tem.next.next != null) {
            ListNode node1 = tem.next;
            ListNode node2 = tem.next.next;
            tem.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tem = node1;
        }
        return node.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs2(head.next.next);
        n.next = head;
        return n;
    }
}