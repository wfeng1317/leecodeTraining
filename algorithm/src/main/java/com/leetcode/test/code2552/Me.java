package com.leetcode.test.code2552;

/**
 * https://leetcode.cn/problems/sum-lists-lcci/
 */
public class Me {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    /**
     * 对位求和，注意进位
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int toUp = 0;
        ListNode res = l1;
        int sum = 0;
        while(l1.next != null && l2.next != null){
            sum = l1.val + l2.val + toUp;
            l1.val = sum % 10;
            toUp = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        sum = l1.val + l2.val + toUp;
        l1.val = sum % 10;
        toUp = sum / 10;
        if(l2.next != null){
            l1.next = l2.next;
        }
        while(l1.next != null){
            l1 = l1.next;
            sum = l1.val + toUp;
            l1.val = sum % 10;
            toUp = sum / 10;
        }
        if(toUp != 0){
            l1.next = new ListNode(toUp);
        }
        return res;
    }
}
