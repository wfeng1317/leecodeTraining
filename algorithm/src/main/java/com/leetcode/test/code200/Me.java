package com.leetcode.test.code200;

import java.util.HashSet;
import java.util.Set;


/**
 * 使用并查集
 */
public class Me {

    int rows =  0;
    int cols = 0;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        UnionFind uf = new UnionFind(rows * cols);
        //遍历grid，将其与左边和上面的1相互组合
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '0'){
                    continue;
                }
                if(func02(i - 1, j) && grid[i - 1][j] == '1'){
                    uf.union(func01(i, j), func01(i - 1, j));
                }
                if(func02(i, j - 1) && grid[i][j - 1] == '1'){
                    uf.union(func01(i, j), func01(i, j - 1));
                }
            }
        }

        //遍历父的个数
        int res = 0;
        Set<Integer> set = new HashSet<>();
        int cur = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '0'){
                    continue;
                }
                cur = uf.find(func01(i, j));
                if(!set.contains(cur)){
                    res++;
                    set.add(cur);
                }
            }
        }
        return res;
    }


    public static class UnionFind{
        int[] parent;
        public UnionFind(int size){
            parent = new int[size];
            for(int i = 0; i < size; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] == x){
                return parent[x];
            }
            return find(parent[x]);
        }

        public void union(int x, int y){
            int xp = find(x);
            int yp = find(y);
            if(xp == yp){
                return;
            }
            parent[xp] = yp;
            return;
        }
    }

    //将二维坐标变一维
    public int func01(int x, int y){
        return x * cols + y;
    }
    //判断是否出界
    public boolean func02(int x, int y){
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
