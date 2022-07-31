package com.leetcode.test.week304.code6132;

import java.util.PriorityQueue;

public class Me {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            pq.offer(nums[i]);
        }
        int ops = 0;
        int minus = 0;
        int cur = 0;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            if (cur - minus == 0) {
                continue;
            }
            ops++;
            minus += (cur - minus);
        }
        return ops;

    }
}
