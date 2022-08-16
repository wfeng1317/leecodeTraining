package com.leetcode.test.code1545;

public class Me {
    public char findKthBit(int n, int k) {
        if(k == 1){
            return '0';
        }
        if(k == (1 << n) - 1){
            return '1';
        }
        int mid = 1 << (n - 1);
        if(k == mid){
            return '1';
        }else if(k < mid){
            return findKthBit(n - 1, k);
        }
        return findKthBit(n - 1, (1 << n) - k) == '1' ? '0' : '1';
    }
}
