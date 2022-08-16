package com.leetcode.test.code70;

public class Me {
    public int climbStairs(int n) {
        int p0 = 1;
        int p1 = 1;
        int temp = 0;
        for(int i = 2; i <= n; i++){
            temp = p1;
            p1 += p0;
            p0 = temp;
        }
        return p1;
    }
}
