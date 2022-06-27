package com.leetcode.test.code1798;

import java.util.Arrays;

public class MeGai {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int right = 0;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= right + 1){
                right += coins[i];
            }else{
                break;
            }
        }
        return right + 1;
    }
}
