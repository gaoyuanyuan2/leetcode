package com.leetcode.demo.list;

import com.leetcode.entity.ListNode;

public class L025ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newListNode = new ListNode(0);
        newListNode.next = head;
        ListNode pre = newListNode;
        // [1,2,3,4,5] 2
        // newListNode
        //  0 1 2 3 4 5 
        //  0 2 1 3 4 5 
        //  0 2 1 4 3 5
        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return newListNode.next;
                }
            }
            ListNode nex = tail.next;
            // 翻转 head 到 tail
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return newListNode.next;
    }




    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode newNode = tail.next;
        ListNode oldNode = head;
        while (newNode != tail) {
            ListNode nextTem = oldNode.next;
            oldNode.next = newNode;
            newNode = oldNode;
            oldNode = nextTem;
        }
        return new ListNode[]{tail, head};
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup2(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the
                // reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}