package com.leetcode.test.code1878;

import java.util.TreeSet;

public class Me {

    int rows = 0;
    int cols = 0;
    public int[] getBiggestThree(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        TreeSet<Integer> tSet = new TreeSet<>();
        int edgeLength = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                edgeLength = 1;
                while(j - edgeLength + 1 >= 0 && j + edgeLength - 1 < cols && (i + (edgeLength - 1) * 2) < rows){
                    tSet.add(func(grid, i, j, edgeLength));
                    edgeLength++;
                }
            }
        }
        int[] res = null;
        if(tSet.size() < 3){
            res = new int[tSet.size()];
        }else{
            res = new int[3];
        }
        for(int i = 0; i < res.length; i++){
            res[i] = tSet.pollLast();
        }
        return res;
    }

    public int func(int[][] grid, int upx, int upy, int edgeLength){
        if(edgeLength == 1){
            return grid[upx][upy];
        }
        int res = grid[upx][upy];
        int lefty = upy;
        int righty = upy;
        for(int i = 1; i < edgeLength; i++){
            upx++;
            res += grid[upx][--lefty];
            res += grid[upx][++righty];
        }
        for(int i = 1; i < edgeLength; i++){
            upx++;
            res += grid[upx][++lefty];
            res += grid[upx][--righty];
        }
        res -= grid[upx][lefty];
        return res;
    }
}
