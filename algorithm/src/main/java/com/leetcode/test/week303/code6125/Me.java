package com.leetcode.test.week303.code6125;

public class Me {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        String[] row = new String[n];
        String[] col = new String[n];
        String cur = "";
        int res = 0;
        for(int i = 0; i < n; i++){
            cur = "";
            for(int j = 0; j < n; j++){
                cur += (grid[i][j] + ",");
            }
            row[i] = cur;
        }
        for(int j = 0; j < n; j++){
            cur = "";
            for(int i = 0; i < n; i++){
                cur += (grid[i][j] + ",");
            }
            col[j] = cur;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(row[i].equals(col[j])){
                    res++;
                }
            }
        }
        return res;

    }
}
