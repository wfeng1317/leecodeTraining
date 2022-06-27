package com.leetcode.test.code2295;

import java.util.HashMap;
import java.util.Map;

public class Me {

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < operations.length; i++){
            int temp = map.get(operations[i][0]);
            nums[temp] = operations[i][1];
            map.remove(operations[i][0]);
            map.put(nums[temp], temp);
        }
        return nums;

    }
}
