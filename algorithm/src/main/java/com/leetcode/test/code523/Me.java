package com.leetcode.test.code523;

/**
 * 超时 94/95
 */
public class Me {

    public boolean checkSubarraySum(int[] nums, int k) {
        //前缀和
        int n = nums.length;
        if(n < 2){
            return false;
        }
        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            preSum[i] += preSum[i - 1] + nums[i - 1];
            if(i >= 2 && (preSum[i] % k) == 0){
                return true;
            }
        }
        for(int i = 2; i <= n; i++){
            int j = i - 2;
            while(j >= 0){
                if((preSum[i] - preSum[j]) % k == 0){
                    return true;
                }
                j--;
            }
        }
        return false;
    }
}
