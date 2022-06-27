package com.leetcode.test.code733;

public class Me {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n =image[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = image[i][j];
            }
        }
        int pre = image[sr][sc];
        dfs(image, pre, sr, sc, color, res);
        return res;
    }

    public void dfs(int[][] image, int pre, int sr, int sc, int color, int[][] res){
        if(sr < 0 || sr == image.length || sc < 0 || sc == image[0].length){
            return;
        }
        if(image[sr][sc] == pre){
            image[sr][sc] = -1;
            res[sr][sc] = color;
            dfs(image, pre, sr - 1, sc, color, res);//up
            dfs(image, pre, sr + 1, sc, color, res);//down
            dfs(image, pre, sr, sc - 1, color, res);//left
            dfs(image, pre, sr, sc + 1, color, res);//right
        }
    }
}
