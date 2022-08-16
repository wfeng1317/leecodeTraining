package com.leetcode.test.code53;

public class Me {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        //以每个位置结尾的最大和
        int pre = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
