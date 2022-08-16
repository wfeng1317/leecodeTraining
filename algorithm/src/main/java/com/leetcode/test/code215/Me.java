package com.leetcode.test.code215;

import java.util.PriorityQueue;

public class Me {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            if(pq.size() < k){
                pq.offer(nums[i]);
            }else{
                if(nums[i] > pq.peek()){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        return pq.peek();

    }
}
