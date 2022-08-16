package com.leetcode.test.code206;

import com.leetcode.test.ListNode;

/**
 * 迭代
 */
public class Me01 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = null;
        while(head != null){
            temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }
}
