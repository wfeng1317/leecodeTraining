package com.leetcode.test.code50;

/**
 * 注意边界
 */
public class Me {

    public double myPow(double x, int n) {
        if(n == 0 || x == 1.0){
            return 1.0;
        }
        double res = 0.0;
        int a = 0;
        double b = x;
        if(n == Integer.MIN_VALUE){
            a = -(n + 1);
        }else{
            a = n < 0 ? -n : n;
        }
        while(a != 0){
            if((a & 1) == 1){
                if(res == 0.0){
                    res = b;
                }else{
                    res *= b;
                }
            }
            b *= b;
            a >>= 1;
        }
        if(n == Integer.MIN_VALUE){
            res *= x;
        }
        return n < 0 ? (1.0 / res) : res;
    }
}
