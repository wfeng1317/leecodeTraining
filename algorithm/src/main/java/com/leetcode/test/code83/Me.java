package com.leetcode.test.code83;


import com.leetcode.test.ListNode;

public class Me {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode pre = head;
        while(cur != null){
            if(cur.val == pre.val){
                cur = cur.next;
                continue;
            }
            //不相等
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur;
        return head;
    }
}
