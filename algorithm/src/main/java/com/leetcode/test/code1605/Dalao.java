package com.leetcode.test.code1605;

public class Dalao {

    /**
     复杂度O(MN) --> 直观解法
     由于题目要求矩阵中所有元素非负，从任一行或者列的角度看，都是把有限的数分配到该行或列的各个位置（两个维度同理）
     在给(i,j)位置元素分配数据时，可以选取其所在行和与列和剩余可分配值中较小的那个，行或列分配完后面自动会取到零
     public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
     int m = rowSum.length;
     int n = colSum.length;
     int[][] ans = new int[m][n];
     for(int i = 0; i < m; i ++){
     for(int j = 0; j < n; j ++){
     ans[i][j] = Math.min(rowSum[i], colSum[j]);
     rowSum[i] -= ans[i][j];
     colSum[j] -= ans[i][j];
     }
     }
     return ans;
     }*/

    // 复杂度O(M+N)：某个{行和}或{列和}分配完则该行或列后面的都无需再考虑
    // 由于每个元素都是取的{行和}或{列和}，每步行或列至少1个已经分配完了，等同于每次完成1行或者1列
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        int i = 0, j = 0;
        while(i < m && j < n){
            if(rowSum[i] < colSum[j]){
                // {行和}小则把其全部分配给该位置，该行后面所有元素都不必再考虑（默认为零，即后面的i++）
                ans[i][j] = rowSum[i];
                // 给该位置分配的值，也需要从列和中分离出去
                colSum[j] -= ans[i][j];
                i ++;
            }else if(rowSum[i] > colSum[j]){
                // {列和}小同理
                ans[i][j] = colSum[j];
                rowSum[i] -= ans[i][j];
                j ++;
            }else{
                ans[i][j] = rowSum[i];
                i ++;
                j ++;
            }
        }
        return ans;
    }

    /* 复杂度O(M+N) --> 最贪的贪心，但是不保证所有元素都为非负数
       设定除了首行和首列外的所有元素均为零，00位置待定，把rowSum和colSum其余值分别放到第0列和第0行
       此时该矩阵仅仅不符合rowSum[0]和colSum[0]，其余均符合条件，只有00位置元素值需确定
       因为数据都集中在首行和首列，因此：(首行和 + 首列和) = 整体和 + {00位置元素值}
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        // 除首个外，把rowSum放到第0列，把colSum放到第0行
        for(int i = 1; i < m; i++){
            ans[i][0] = rowSum[i];
        }
        for(int j = 1; j < n; j++){
            ans[0][j] = colSum[j];
        }
        // 计算整个矩阵中所有元素的和
        int sum = 0;
        for(int i = 0; i < m; i++){
            sum += rowSum[i];
        }
        // 由于所有元素都集中在首行和首列，所以(首行和+首列和) = 整体和 + 第00位置的值
        ans[0][0] = rowSum[0] + colSum[0] - sum;
        return ans;
    }*/

}
