package com.leetcode.test.code1221;

public class Me {
    public int balancedStringSplit(String s) {
        int L = 0;
        int R = 0;
        int i = 0;
        int res = 0;
        while(i < s.length()){
            if(s.charAt(i) == 'L'){
                L++;
            }else{
                R++;
            }
            i++;
            if(L == R){
                res++;
            }
        }
        return res;
    }
}
