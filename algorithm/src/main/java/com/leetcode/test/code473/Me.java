package com.leetcode.test.code473;

import java.util.Arrays;

public class Me {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        if(n < 4){
            return false;
        }
        int sum = 0;
        Arrays.sort(matchsticks);
        for(int i = 0; i < n; i++){
            sum += matchsticks[i];
        }
        if(sum % 4 != 0){
            return false;
        }
        int bian = sum / 4;
        boolean[] used = new boolean[n];
        return f(matchsticks, 0, 4, bian, bian, used);
    }


    public static boolean f(int[] matchsticks, int start, int restBian, int bian, int restCur, boolean[] used){
        if(restBian == 0){
            return true;
        }
        if(restCur == 0){
            return f(matchsticks, 0, restBian - 1, bian, bian, used);
        }
        int n = matchsticks.length;
        boolean res = false;
        for(int i = start; i < n; i++){
            if(matchsticks[i] > restCur){
                break;
            }
            if(used[i]){
                continue;
            }
            used[i] = true;
            if(f(matchsticks, i + 1, restBian, bian, restCur - matchsticks[i], used)){
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}
