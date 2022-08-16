package com.leetcode.test.code1403;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Me {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.add(i);
            sum += i;
        }
        int delSum = 0;
        while(pq.size() > 0){
            delSum += pq.peek();
            if(sum - delSum <= delSum){
                break;
            }
            pq.poll();
        }
        List<Integer> res = new ArrayList<>();
        while(pq.size() > 0){
            res.add(pq.poll());
        }
        res.sort((e1, e2) -> e2 - e1);
        return res;
    }
}
