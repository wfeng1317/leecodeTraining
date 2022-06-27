package com.leetcode.test.week299.code6101;

public class Me {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                if(x == y || (x + y) == n - 1){
                    if(grid[x][y] == 0){
                        return false;
                    }
                }else{
                    if(grid[x][y] != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
