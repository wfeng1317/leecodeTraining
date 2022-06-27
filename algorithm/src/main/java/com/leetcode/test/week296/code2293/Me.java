package com.leetcode.test.code2293;

public class Me {

    public int minMaxGame(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        while(nums.length != 1){
            int n = nums.length;
            int[] new_num = new int[n / 2];
            for(int i = 0; i < n / 2; i++){
                new_num[i] = (i & 1) == 0 ? Math.min(nums[2 * i], nums[2 * i + 1]) : Math.max(nums[2 * i], nums[2 * i + 1]);
            }
            nums = new_num;
        }
        return nums[0];
    }
}
