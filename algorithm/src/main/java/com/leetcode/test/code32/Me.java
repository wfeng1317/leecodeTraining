package com.leetcode.test.code32;

public class Me {
    public int longestValidParentheses(String s) {
        //以某个位置开头的最长括号
        int n = s.length();
        int res = 0;
        int[] dp = new int[n];
        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) == ')'){
                continue;
            }
            if(s.charAt(i + 1) == '('){
                if(i + dp[i + 1] + 1 < n && s.charAt(i + dp[i + 1] + 1) == ')'){
                    dp[i] = dp[i + 1] + 2;
                    if(i + dp[i + 1] + 1 + 1 < n){
                        dp[i] += dp[i + dp[i + 1] + 1 + 1];
                    }
                }
            }else{
                dp[i] = 2;
                if(i + 2 < n){
                    dp[i] += dp[i + 2];
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
