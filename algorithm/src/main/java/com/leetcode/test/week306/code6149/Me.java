package com.leetcode.test.week306.code6149;

public class Me {
    public int edgeScore(int[] edges) {
        int res = 0;
        long max = 0;
        int n = edges.length;
        long[] leijia = new long[n];
        for(int i = 0; i < n; i++){
            leijia[edges[i]] += i;
        }
        for(int i = 0; i < n; i++){
            if(leijia[i] > max){
                max = leijia[i];
                res = i;
            }
        }
        return res;
    }
}
