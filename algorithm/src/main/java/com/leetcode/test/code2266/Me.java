package com.leetcode.test.code2266;

public class Me {
    int rows = 0;
    int cols = 0;
    public boolean hasValidPath(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        if (grid[0][0] != '(' || grid[rows - 1][cols - 1] != ')' || (rows + cols) % 2 == 0) {
            return false;
        }
        int grids = rows * cols;
        // return process(grid, 0, 0, 0);
        boolean[][] dp = new boolean[grids][(rows + cols) / 2 + 2];
        process01(grid, dp, grids);
        return dp[0][0];
    }

    /**
     * 暴力递归
     */
    public boolean process(char[][] grid, int x, int y, int minus) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return false;
        }
        int newMinus = grid[x][y] == '(' ? minus + 1 : minus - 1;
        if (x == rows - 1 && y == cols - 1) {
            return newMinus == 0;
        }
        if (newMinus < 0) {
            return false;
        }
        return process(grid, x, y + 1, newMinus) || process(grid, x + 1, y, minus);
    }


    /**
     * 暴力递归转dp
     * 将二维坐标转换成一维坐标
     * dp[i][j]的含义：在i位置给我遗留了j个左括号数量需要我处理
     */
    public void process01(char[][] grid, boolean[][] dp, int grids) {
        //最后一个位置的左的数量为0时才为true
        dp[grids - 1][1] = true;
        int x = 0;
        int y = 0;
        int target = 0;
        for (int i = grids - 2; i >= 0; i--) {
            x = i / cols;
            y = i % cols;
            if (grid[x][y] == ')') {
                target = -1;
            } else {
                target = 1;
            }
            for (int j = 0; j < (rows + cols) / 2 + 2; j++) {
                if (j + target >= 0 && j + target < (rows + cols) / 2 + 2) {
                    if (y + 1 < cols) {
                        dp[i][j] = dp[i][j] || dp[i + 1][j + target];
                    }
                    if (x + 1 < rows) {
                        dp[i][j] = dp[i][j] || dp[i + cols][j + target];
                    }
                }
            }
        }
    }
}
