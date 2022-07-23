package com.leetcode.test.code1937;

/**
 * 优化前 O(n*m*m)
 */
public class Me01 {
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[][] dp = new long[n][m];
        //选择[i, j]格子的最大总得分
        for(int j = 0; j < m; j++){
            dp[0][j] = points[0][j];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < m; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + points[i][j] - Math.abs(j - k));
                }
            }
        }
        long res = 0L;
        for(int j = 0; j < m; j++){
            res = Math.max(res, dp[n - 1][j]);
        }
        return res;
    }
}
