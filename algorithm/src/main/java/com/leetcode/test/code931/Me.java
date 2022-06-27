package com.leetcode.test.code931;

public class Me {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < m; j++){
                dp[i][j] = matrix[i][j] + dp[i + 1][j];
                if(j != 0){
                    dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i + 1][j - 1]);
                }
                if(j != m - 1){
                    dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i + 1][j + 1]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        //最后遍历第一行，找到最小值
        for(int j = 0; j < m; j++){
            res = Math.min(res, dp[0][j]);
        }
        return res;
    }
}
