package com.leetcode.test.code206;

import com.leetcode.test.ListNode;

/**
 * 递归
 */
public class Me02 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode pre = reverseList(head.next);
        ListNode res = pre;
        head.next = null;
        while(pre.next != null){
            pre = pre.next;
        }
        pre.next = head;
        return res;
    }
}
