package com.leetcode.test.code382;

import com.leetcode.test.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Me {
    List<Integer> vals = null;
    Random r = new Random();

    public Me(ListNode head) {
        vals = new ArrayList<>();
        while(head != null){
            vals.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int n = vals.size();
        return vals.get(r.nextInt(n));
    }
}
