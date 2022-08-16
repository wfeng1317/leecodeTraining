package com.leetcode.test.code25;

import com.leetcode.test.ListNode;

public class Me {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int i = 1;
        ListNode cur = head;
        ListNode tail = null;
        while(cur != null && i <= k){
            cur = cur.next;
            if(i == k - 1){
                tail = cur;
            }
            i++;
        }
        if(tail == null){
            return head;
        }
        ListNode newTail = head;
        ListNode pre = null;
        ListNode temp = null;
        while(pre != tail){
            temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }
        newTail.next = reverseKGroup(cur, k);
        return pre;
    }
}
