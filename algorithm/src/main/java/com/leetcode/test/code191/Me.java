package com.leetcode.test.code191;

public class Me {
    public int hammingWeight(int n) {
        int k = n;
        if(n < 0){
            k = ~n;
        }
        int res = 0;
        while(k > 0){
            if((k & 1) == 1){
                res++;
            }
            k >>>= 1;
        }
        return n >= 0 ? res : 32 - res;
    }
}
