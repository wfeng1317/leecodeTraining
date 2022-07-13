package com.leetcode.test.week301.code6115;

public class Dalao01 {
    public int idealArrays(int n, int maxValue) {
        int sum = 0, dp[][] = new int[14][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < 14; i++) {
            dp[i][1] = 1;
            for (int j = 2; j <= n; j++) {
                for (int k = 0; k <= i; k++) {
                    dp[i][j] = (dp[i][j] + dp[k][j - 1]) % 1000000007;
                }
            }
        }
        for (int i = 1, j = 1; i <= maxValue; j = ++i) {
            long prod = 1;
            for (int k = 2; k <= Math.sqrt(i); k++) {
                int count = 0;
                for (; j % k == 0; j /= k, count++) {
                }
                prod = prod * dp[count][n] % 1000000007;
            }
            if (j > 1) {
                prod = prod * dp[1][n] % 1000000007;
            }
            sum = (int) (sum + prod) % 1000000007;
        }
        return sum;
    }
}
