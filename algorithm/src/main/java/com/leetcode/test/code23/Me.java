package com.leetcode.test.code23;

import com.leetcode.test.ListNode;

import java.util.PriorityQueue;

public class Me {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        if(lists.length == 0){
            return res.next;
        }
        ListNode cur = res;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for(ListNode ln : lists){
            if(ln == null){
                continue;
            }
            pq.offer(ln);
        }
        ListNode min = null;
        while(pq.size() > 0){
            min = pq.poll();
            cur.next = min;
            cur = cur.next;
            if(min.next != null){
                pq.offer(min.next);
            }
        }
        return res.next;

    }
}
