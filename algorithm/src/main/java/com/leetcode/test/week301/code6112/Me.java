package com.leetcode.test.week301.code6112;

public class Me {
    public int fillCups(int[] amount) {
        //每次选择两个最多的
        int res = 0;
        int max1 = 0;
        int max2 = 0;
        while(amount[0] > 0 || amount[1] > 0 || amount[2] > 0){
            max1 = Math.max(amount[0], amount[1]);
            max2 = Math.max(amount[2], (max1 == amount[0] ? amount[1] : amount[0]));
            if(max1 > 0){
                if(max1 == amount[0]){
                    amount[0]--;
                }else if(max1 == amount[1]){
                    amount[1]--;
                }else{
                    amount[2]--;
                }
            }
            if(max2 > 0){
                if(max2 == amount[0]){
                    amount[0]--;
                }else if(max2 == amount[1]){
                    amount[1]--;
                }else{
                    amount[2]--;
                }
            }
            res++;
        }
        return res;

    }
}
