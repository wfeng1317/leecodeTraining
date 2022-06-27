package com.leetcode.test.code1848;

public class Me {
    public int getMinDistance(int[] nums, int target, int start) {
        if(nums[start] == target){
            return 0;
        }
        int n = nums.length;
        int left = start;
        int right = start;
        while(nums[left] != target && nums[right] != target){
            if(left > 0){
                left--;
            }
            if(right < n - 1){
                right++;
            }
        }
        return nums[right] == target ? right - start : start - left;
    }
}
