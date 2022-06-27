package com.leetcode.test.code1911;

public class Me {

    public long maxAlternatingSum(int[] nums) {
        long sum = 0;
        int i = 0;
        int count = 0;
        int n = nums.length;
        int flag = 0;//flag为0表示递增找偶，1表示递减找奇
        while(i < n - 1){
            if(flag == 0){
                if(nums[i] <= nums[i + 1]){
                    i++;
                    continue;
                }else{
                    sum += nums[i];
                    count++;
                    i++;
                    flag = 1;
                }
            }else{
                if(nums[i] >= nums[i + 1]){
                    i++;
                    continue;
                }else{
                    sum -= nums[i];
                    count++;
                    i++;
                    flag = 0;
                }
            }
        }
        if(count % 2 == 0){
            sum += nums[n - 1];
        }
        return sum;
    }
}
