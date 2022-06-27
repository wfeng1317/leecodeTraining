package com.leetcode.test.code1292;

public class Me {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                prefixSum[i][j] = prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + prefixSum[i - 1][j] + mat[i - 1][j - 1];
            }
        }
        int res = 0;
        //计算每个位置为右下角的满足条件的最大边长
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                while(i - res - 1 >= 0 && j - res - 1 >= 0){
                    int cur = prefixSum[i][j] + prefixSum[i - res - 1][j - res - 1] - prefixSum[i - res - 1][j] - prefixSum[i][j - res - 1];
                    if(cur > threshold){
                        break;
                    }
                    res++;
                }
            }
        }
        return res;
    }
}
