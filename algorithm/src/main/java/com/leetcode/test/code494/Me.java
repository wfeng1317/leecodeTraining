package com.leetcode.test.code494;

import java.util.HashMap;
import java.util.Map;

public class Me {

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        //dp[i]: 表示从i往后所有数字的方法数
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();

        return f(nums, target, 0, dp);
    }

    public int f(int[] nums, int rest, int cur, Map<Integer, Map<Integer, Integer>> dp){
        if(cur == nums.length){
            return rest == 0 ? 1 : 0;
        }
        if(dp.containsKey(cur) && dp.get(cur).containsKey(rest)){
            return dp.get(cur).get(rest);
        }
        if(!dp.containsKey(cur)){
            dp.put(cur, new HashMap<Integer, Integer>());
        }
        dp.get(cur).put(rest, f(nums, rest + nums[cur], cur + 1, dp) + f(nums, rest - nums[cur], cur + 1, dp));
        return dp.get(cur).get(rest);
    }
}
