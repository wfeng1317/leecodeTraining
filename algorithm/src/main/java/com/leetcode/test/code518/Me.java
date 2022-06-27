package com.leetcode.test.code518;

public class Me {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j <= amount; j++){
                int k = 0;
                while(coins[i] * k <= j){
                    dp[i][j] += dp[i + 1][j - coins[i] * k];
                    k++;
                }
            }
        }
        return dp[0][amount];
    }
}
