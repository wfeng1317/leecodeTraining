package com.leetcode.test.code73;

public class Me {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int firstRowZero = 1;//第0行是否需要变0
        //先遍历第0行与第0列，找出是否需要变0
        for(int i = 0; i < cols; i++){
            if(matrix[0][i] == 0){
                firstRowZero = 0;
                break;
            }
        }
        //matrix[0][0] 表示第0列是否需要全变0
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                matrix[0][0] = 0;
                break;
            }
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //先把中间置零，在处理两边
        for(int i = 1; i < rows; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < cols; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < cols; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < rows; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }
        }
        if(firstRowZero == 0){
            for(int j = 0; j < cols; j++){
                matrix[0][j] = 0;
            }
        }
        return;
    }
}
