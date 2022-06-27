package com.leetcode.test.code908;

public class Me {

    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int res = max - min - 2 * k;
        return res > 0 ? res : 0;
    }
}
