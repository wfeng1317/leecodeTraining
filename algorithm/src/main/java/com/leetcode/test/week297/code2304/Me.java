package com.leetcode.test.code2304;

import java.util.Arrays;

public class Me {

    int rows = 0;
    int cols = 0;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        rows = grid.length;
        cols = grid[0].length;
        int[] dp = new int[moveCost.length];
        Arrays.fill(dp, -1);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < cols; i++){
            min = Math.min(min, f(grid, moveCost, 0, i, dp));
        }
        return min;

    }


    public int f(int[][] grid, int[][] moveCost, int curRow, int curCol, int[] dp){
        if(dp[grid[curRow][curCol]] != -1){
            return dp[grid[curRow][curCol]];
        }
        if(curRow == rows - 1){
            dp[grid[curRow][curCol]] = grid[curRow][curCol];
            return dp[grid[curRow][curCol]];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < cols; i++){
            min = Math.min(min, grid[curRow][curCol] + moveCost[grid[curRow][curCol]][i] + f(grid, moveCost, curRow + 1, i, dp));
        }
        dp[grid[curRow][curCol]] = min;
        return dp[grid[curRow][curCol]];
    }
}
