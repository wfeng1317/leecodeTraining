package com.leetcode.test.code2459;

import java.util.Deque;
import java.util.LinkedList;

public class Me {

    /**
     * 将求最大全为1矩阵的最大面积，把问题转换成柱子问题
     * 数组中每个位置的往左数连续的1作为矩阵的高，上下行离当前位置最近且更小的范围作为矩阵的宽
     * 遍历整个数组，找到每个位置作为矩阵的高的最大面积
     * @param matrix
     * @return
     */
    public int maximalRectangle(String[] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length();
        int[][] left = new int[rows][cols];
        //得到i行j列开始往左连续的1的个数
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i].charAt(j) == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        Deque<Integer> stack = new LinkedList<>();
        int[] leftMin = new int[rows];
        int max = Integer.MIN_VALUE;
        int cur = 0;
        //对每一列进行处理
        for(int i = 0; i < cols; i++){
            stack.addLast(-1);
            for(int j = 0; j < rows; j++){
                while(stack.getLast() != -1 && left[j][i] <= left[stack.getLast()][i]){
                    cur = stack.removeLast();
                    max = Math.max(max, left[cur][i] * (j - leftMin[cur] - 1));
                }
                leftMin[j] = stack.getLast();
                stack.addLast(j);
            }
            while(stack.getLast() != -1){
                cur = stack.removeLast();
                max = Math.max(max, left[cur][i] * (rows - leftMin[cur] - 1));
            }
        }
        return max;
    }
}
