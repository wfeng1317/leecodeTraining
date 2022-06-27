package com.leetcode.test.code2202;

/**
 * 注意边界 k == 0 以及 n == 1 的情况
 */
public class Me {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if(k == 0){
            return nums[0];
        }
        if(n == 1){
            return (k & 1) == 0 ? nums[0] : -1;
        }
        int i = 0;
        int max = -1;
        //找到k-1的最大数
        while(i < n && k > 1){
            max = Math.max(max, nums[i]);
            i++;
            k--;
        }
        return i < n - 1 ? Math.max(max, nums[i + 1]) : max;
    }
}
