package com.leetcode.test.code268;

public class Me {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum -= nums[i];
            sum += i;
        }
        return sum + n;
    }
}
