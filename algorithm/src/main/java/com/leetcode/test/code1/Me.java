package com.leetcode.test.code1;

import java.util.HashMap;
import java.util.Map;

public class Me {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        int r1 = 0;
        int r2 = 0;
        int other = 0;
        for(int i = 0; i < n; i++){
            other = target - nums[i];
            if(other == nums[i]){
                if(map.get(nums[i]) > 1){
                    r1 = nums[i];
                    r2 = nums[i];
                    break;
                }
            }else{
                if(map.containsKey(other)){
                    r1 = nums[i];
                    r2 = other;
                    break;
                }
            }
        }
        int[] res = new int[]{-1, -1};
        for(int i = 0; i < n; i++){
            if(nums[i] == r1 && res[0] == -1){
                res[0] = i;
            }else if(nums[i] == r2 && res[1] == -1){
                res[1] = i;
            }
        }
        return res;
    }
}
