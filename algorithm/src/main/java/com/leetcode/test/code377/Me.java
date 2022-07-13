package com.leetcode.test.code377;

/**
 * 注意target为0时表示有一组
 */
public class Me {

    public int combinationSum4(int[] nums, int target) {
        //每个target所能得到的组合数
        //int[] dp01 = new int[target + 1];
        int[] dp02 = new int[target + 1];
        //Arrays.fill(dp01, -1);
        //dp01[0] = 1;
        process02(nums, target, dp02);
        return dp02[target];
        //return process01(nums, target, dp01);
    }

    /**
     * 记忆化搜索
     */
    public int process01(int[] nums, int target, int[] dp){
        if(target < 0){
            return 0;
        }
        if(dp[target] != -1){
            return dp[target];
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res += process01(nums, target - nums[i], dp);
        }
        dp[target] = res;
        return dp[target];
    }

    /**
     * dp
     */
    public void process02(int[] nums, int target, int[] dp){
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(i - nums[j] >= 0){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
    }
}
