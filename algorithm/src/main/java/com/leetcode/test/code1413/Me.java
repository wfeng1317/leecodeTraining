package com.leetcode.test.code1413;

public class Me {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int preSum = 0;
        for(int i = 0; i < n; i++){
            preSum += nums[i];
            res = Math.min(res, preSum);
        }
        return res >= 0 ? 1 : -res + 1;

    }
}
