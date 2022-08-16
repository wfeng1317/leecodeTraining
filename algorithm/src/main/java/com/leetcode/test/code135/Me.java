package com.leetcode.test.code135;

public class Me {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candys = new int[n];
        candys[0] = 1;
        for(int i = 1; i < n; i++){
            if(ratings[i] <= ratings[i - 1]){
                candys[i] = 1;
            }else{
                candys[i] = candys[i - 1] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                candys[i] = Math.max(candys[i], candys[i + 1] + 1);
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res += candys[i];
        }
        return res;
    }
}
