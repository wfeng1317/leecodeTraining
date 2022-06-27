package com.leetcode.test.week299.code6100;

public class Me {

    public int countHousePlacements(int n) {
        long mod = 1000000007;
        long[][] dp = new long[n][2];
        dp[n - 1][0] = 1;
        dp[n - 1][1] = 1;
        for(int i = n - 2; i >= 0; i--){
            dp[i][0] = (dp[i + 1][0] + dp[i + 1][1]) % mod;
            dp[i][1]= dp[i + 1][0];
        }
        long res = (dp[0][0] + dp[0][1]) % mod;
        return (int)(res * res % mod);
    }
}
