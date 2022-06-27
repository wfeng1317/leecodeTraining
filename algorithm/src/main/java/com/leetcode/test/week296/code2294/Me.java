package com.leetcode.test.code2294;

import java.util.Arrays;

public class Me {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int left = 0;
        int right = 0;
        while(left < n && right < n){
            if(nums[right] - nums[left] <= k){
                right++;
            }else{
                res++;
                left = right;
            }
        }
        return res + 1;
    }
}
