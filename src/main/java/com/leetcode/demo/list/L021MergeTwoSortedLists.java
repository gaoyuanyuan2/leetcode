package com.leetcode.demo.list;

import com.leetcode.entity.ListNode;

public class L021MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(-1);
        ListNode temNode = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temNode.next = l1;
                l1 = l1.next;
            } else {
                temNode.next = l2;
                l2 = l2.next;
            }
            // 当前节点后移继续拼接
            temNode = temNode.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        temNode.next = (l1 == null ? l2 : l1);
        return newNode.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}