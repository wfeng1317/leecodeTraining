package com.leetcode.test.code523;

import java.util.HashMap;
import java.util.Map;

/**
 * 加了一个哈希表
 */
public class Me02 {

    public boolean checkSubarraySum(int[] nums, int k) {
        //前缀和
        int n = nums.length;
        if(n < 2){
            return false;
        }
        int[] preSum = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            preSum[i] += preSum[i - 1] + nums[i - 1];
            if(i >= 2 && (preSum[i] % k) == 0){
                return true;
            }
            int rest = preSum[i] % k;
            if(map.containsKey(rest)){
                if(i - map.get(rest) >= 2){
                    return true;
                }
            }else{
                map.put(rest, i);
            }
        }
        return false;
    }
}
