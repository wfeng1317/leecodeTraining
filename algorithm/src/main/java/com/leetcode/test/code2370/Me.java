package com.leetcode.test.code2370;

import java.util.ArrayList;
import java.util.List;

public class Me {

    public int flipChess(String[] chessboard) {
        int n = chessboard.length;
        int m = chessboard[0].length();
        int[][] board = new int[n][m];
        int max = 0;
        //在每一个空位置下黑棋，看看最终能翻转多少枚白棋
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                clear(board, chessboard);
                if(board[i][j] == 0){
                    max = Math.max(max, dfs(board, n, m, i, j));
                }
            }
        }
        return max;
    }


    public int dfs(int[][] board, int n, int m, int x, int y){
        List<int[]> change = new ArrayList<>();
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        //0, 1, 2
        //3,  , 4
        //5, 6, 7
        int startx = 0;
        int starty = 0;
        int count = 0;
        //左上
        for(int i = 0; i < 8; i++){
            startx = x + dir[i][0];
            starty = y + dir[i][1];
            count = 0;
            while(isArea(n, m, startx, starty) && board[startx][starty] == 1){
                startx += dir[i][0];
                starty += dir[i][1];
                count++;
            }
            if(isArea(n, m, startx, starty) && board[startx][starty] == 2){//收集
                while(count > 0){
                    startx -= dir[i][0];
                    starty -= dir[i][1];
                    board[startx][starty] = 2;
                    count--;
                    change.add(new int[]{startx, starty});
                }
            }
        }
        int res = change.size();
        for(int i = 0; i < change.size(); i++){
            res += dfs(board, n, m, change.get(i)[0], change.get(i)[1]);
        }
        return res;
    }
    public void clear(int[][] board, String[] chessboard){
        //黑棋为2，白棋为1
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(chessboard[i].charAt(j) == 'X'){
                    board[i][j] = 2;
                }else if(chessboard[i].charAt(j) == 'O'){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }
    }

    public boolean isArea(int n, int m, int x, int y){
        return (x >= 0) && (x < n) && (y >= 0) && (y < m);
    }
}
