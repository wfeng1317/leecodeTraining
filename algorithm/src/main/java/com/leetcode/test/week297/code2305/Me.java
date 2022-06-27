package com.leetcode.test.code2305;

public class Me {

    public int distributeCookies(int[] cookies, int k) {
        int[] sum = new int[k];
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        f(cookies, 0, sum, k, res);
        return res[0];
    }

    public void f(int[] cookies, int cur, int[] sum, int k, int[] res){
        if(cur == cookies.length){
            res[0] = Math.min(res[0], f2(sum));
            return;
        }
        for(int i = 0; i < k; i++){
            sum[i] += cookies[cur];
            f(cookies, cur + 1, sum, k, res);
            sum[i] -= cookies[cur];
        }
    }

    public int f2(int[] sum){
        int max = sum[0];
        for(int i = 1; i < sum.length; i++){
            max = Math.max(max, sum[i]);
        }
        return max;
    }
}
