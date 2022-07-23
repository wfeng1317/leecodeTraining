package com.leetcode.test.code2580;

public class Me {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[amount + 1][n];
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < n; j++){
                if(coins[j] > i){
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    min = Math.min(min, dp[i - coins[j]][k]);
                }
                if(min != Integer.MAX_VALUE){
                    dp[i][j] = min + 1;
                }
            }
        }
        for(int k = 0; k < n; k++){
            res = Math.min(res, dp[amount][k]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
