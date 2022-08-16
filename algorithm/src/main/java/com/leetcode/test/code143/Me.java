package com.leetcode.test.code143;

import com.leetcode.test.ListNode;

public class Me {
    public void reorderList(ListNode head) {
        ListNode cur = head;
        //找到需要插入的最开始节点
        int i = 0;
        while(cur != null){
            cur = cur.next;
            i++;
        }
        cur = head;
        for(int j = 0; j < (i - 1) / 2; j++){
            cur = cur.next;
        }
        ListNode cha = cur.next;
        cha = reverse(cha);
        cur.next = null;
        cur = head;
        ListNode temp1 = null;
        ListNode temp2 = null;
        while(cha != null){
            temp1 = cur.next;
            cur.next = cha;
            temp2 = cha.next;
            cha.next = temp1;
            cha = temp2;
            cur = temp1;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
