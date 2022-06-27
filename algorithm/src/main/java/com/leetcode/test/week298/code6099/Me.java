package com.leetcode.test.week298.code6099;

public class Me {
    public static int longestSubsequence(String s, int k) {
        int n = s.length();
        int sum = 0;
        int count = 0;
        int temp = 1;
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '1' && temp <= k && sum + temp <= k){
                sum += temp;
                count++;
                if(temp <= k) temp <<= 1;//防止溢出
            }else if(s.charAt(i) == '0'){
                count++;
                if(temp <= k) temp <<= 1;//防止溢出
            }
        }
        return count;
    }
}
