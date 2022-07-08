package com.leetcode.test.code2563;

import java.util.LinkedList;

public class Me {
    public int numDistinct(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        int[][] dp = new int[sn + 1][tn + 1];
        for(int i = 0; i <= sn; i++){
            dp[i][tn] = 1;
        }
        for(int i = sn - 1; i >= 0; i--){
            for(int j = tn - 1; j >= 0; j--){
                dp[i][j] += dp[i + 1][j];
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
