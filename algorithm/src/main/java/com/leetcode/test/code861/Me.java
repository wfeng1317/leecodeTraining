package com.leetcode.test.code861;

/**
 * 贪心，需注意先换后换一个样。而且行首位为0必换。
 */
public class Me {

    int rows = 0;
    int cols = 0;
    public int matrixScore(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            //只要这一行第一位是0，就换
            if(grid[i][0] == 0){
                //换
                change(grid, i, 0);
            }
        }
        for(int j = 0; j < cols; j++){
            //只要这一列0比1多就换
            int numOne = 0;
            for(int i = 0; i < rows; i++){
                numOne = grid[i][j] == 1 ? numOne + 1 : numOne - 1;
            }
            if(numOne < 0){
                //换
                change(grid, j, 1);
            }
        }
        int res = 0;
        for(int i = 0; i < rows; i++){
            int start = 0;
            for(int j = cols - 1; j >= 0; j--){
                res = grid[i][j] == 1 ? res + (1 <<  start) : res;
                start++;
            }
        }
        return res;
    }

    public void change(int[][] grid, int idx, int type){
        if(type == 0){
            //变行
            for(int j = 0; j < cols; j++){
                grid[idx][j] = grid[idx][j] == 1 ? 0 : 1;
            }
        }else{
            //变列
            for(int i = 0; i < rows; i++){
                grid[i][idx] = grid[i][idx] == 1 ? 0 : 1;
            }
        }
    }
}
