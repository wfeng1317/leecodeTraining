package com.leetcode.test.code2130;

import com.leetcode.test.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Me {
    public int pairSum(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        while(head != null){
            nodes.add(head.val);
            head = head.next;
        }
        int max = 0;
        int n = nodes.size();
        for(int i = 0; i < n / 2; i++){
            max = Math.max(max, nodes.get(i) + nodes.get(n - 1 - i));
        }
        return max;
    }
}
