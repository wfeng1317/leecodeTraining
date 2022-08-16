package com.leetcode.test.week306.code6148;

public class Me {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for(int i = 0; i < n - 2; i++){
            for(int j = 0; j < n - 2; j++){
                res[i][j] = f(grid, i, j);
            }
        }
        return res;
    }

    public int f(int[][] grid, int li, int ri){
        int max = 0;
        for(int i = li; i < li + 3; i++){
            for(int j = ri; j < ri + 3; j++){
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
