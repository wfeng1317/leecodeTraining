package com.leetcode.test.code526;


public class Me {

    public int countArrangement(int n) {
        //记录已使用过的整数
        boolean[] isUsed = new boolean[n + 1];
        return process(n, 1, isUsed);
    }

    //cur表示当前来到的位置
    //isUsed表示哪些数字已被使用过
    public int process(int n, int cur, boolean[] isUsed){
        if(cur == n + 1){
            return 1;
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            if(isUsed[i]){
                continue;
            }
            if(cur % i == 0 || i % cur == 0){
                isUsed[i] = true;
                res += process(n, cur + 1, isUsed);
                isUsed[i] = false;
            }
        }
        return res;
    }
}
