package com.leetcode.test.code2195;

import java.util.Arrays;

public class Me {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int pre = 0;
        int i = 0;
        int count = k;
        long res = 0L;
        while(i < n && count > 0){
            //若当前值与前一个值之差大于count
            if(nums[i] - pre == 1 || nums[i] - pre == 0){
                pre = nums[i];
                i++;
                continue;
            }
            if(nums[i] - pre - 1 > count){
                res += f(pre + 1, pre + count);
                count = 0;
            }else{
                res += f(pre + 1, nums[i] - 1);
                count -= (nums[i] - pre - 1);
            }
            pre = nums[i];
            i++;
        }
        if(count > 0){
            res += f(nums[i - 1] + 1, nums[i - 1] + count);
        }
        return res;
    }

    public long f(long left, long right){
        return (left + right) * (right - left + 1) / 2;
    }
}
