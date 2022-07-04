package com.leetcode.test.code840;

public class Me {

    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n < 3 || m < 3){
            return 0;
        }
        int res = 0;
        //遍历每一种情况
        //以(i, j)为左上角
        for(int i = 0; i <= n - 3; i++){
            for(int j = 0; j <= m - 3; j++){
                if(f(grid, i, j)){
                    res++;
                }
            }
        }
        return res;
    }

    public boolean f(int[][] grid, int a, int b){
        boolean[] exists = new boolean[10];
        //先算出第一行的sum
        int res = grid[a][b] + grid[a][b + 1] + grid[a][b + 2];
        //先判断行
        for(int i = a; i < a + 3; i++){
            int temp = 0;
            for(int j = b; j < b + 3; j++){
                if(grid[i][j] == 0 || grid[i][j] >= 10 || exists[grid[i][j]]){
                    return false;
                }
                exists[grid[i][j]] = true;
                temp += grid[i][j];
            }
            if(temp != res){
                return false;
            }
        }
        //再判断列
        for(int j = b; j < b + 3; j++){
            if((grid[a][j] + grid[a + 1][j] + grid[a + 2][j]) != res){
                return false;
            }
        }
        //再判断对角线
        if((grid[a][b] + grid[a + 1][b + 1] + grid[a + 2][b + 2]) != res){
            return false;
        }
        if((grid[a][b + 2] + grid[a + 1][b + 1] + grid[a + 2][b]) != res){
            return false;
        }
        return true;
    }
}
