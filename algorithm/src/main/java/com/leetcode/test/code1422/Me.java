package com.leetcode.test.code1422;

public class Me {
    public int maxScore(String s) {
        int n = s.length();
        int oneSum = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                oneSum++;
            }
        }
        int zero = 0;
        int one = 0;
        int max = 0;
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == '0'){
                zero++;
            }else{
                one++;
            }
            max = Math.max(max, zero + oneSum - one);
        }
        return max;


    }
}
