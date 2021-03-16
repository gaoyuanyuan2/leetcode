package com.leetcode.demo.list;

import com.leetcode.entity.ListNode;

public class L141LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        if (head.next == head) return true;
        ListNode nextNode = head.next;
        head.next = head;
        boolean isCycle = hasCycle2(nextNode);
        return isCycle;
    }
}

