package com.leetcode.test.code121;

public class Me {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        int sufMax = prices[n - 1];
        for(int i = n - 2; i >= 0; i--){
            res = Math.max(res, sufMax - prices[i]);
            sufMax = Math.max(sufMax, prices[i]);
        }
        return res;
    }
}
