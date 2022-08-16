package com.leetcode.test.code628;

import java.util.Arrays;

public class Me {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        if(n == 3){
            return nums[0] * nums[1] * nums[2];
        }
        //一正二负，三正
        Arrays.sort(nums);
        if(nums[n - 1] < 0){
            //没有正数，取三个最大的负数
            return nums[n - 1] * nums[n - 2] * nums[n - 3];
        }
        if(nums[n - 3] < 0){
            //正数少于三个，最大正数与最小的两个负数
            return nums[0] * nums[1] * nums[n - 1];
        }
        //正数大于等于三个
        int res = nums[n - 1] * nums[n - 2] * nums[n - 3];
        //若负数大于等于2个
        if(nums[1] < 0){
            res = Math.max(res, nums[0] * nums[1] * nums[n - 1]);
        }
        return res;
    }
}
