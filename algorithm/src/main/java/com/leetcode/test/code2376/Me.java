package com.leetcode.test.code2376;

import java.util.ArrayList;
import java.util.List;

public class Me {
    public int countSpecialNumbers(int n) {
        List<Integer> nums = new ArrayList<>();
        while(n > 0){
            nums.add(n % 10);
            n /= 10;
        }
        int res = 0;
        int s = 0;
        int k = 0;
        //先存放位数小于nums.size()的满足条件的数
        for(int i = 1; i < nums.size(); i++){
            s = 9;
            k = 9;
            for(int j = 0; j < i - 1; j++){
                s *= k;
                k--;
            }
            res += s;
        }
        boolean[] used = new boolean[10];
        for(int i = nums.size() - 1; i >= 0; i--){
            for(int j = (nums.size() - 1 == i ? 1 : 0); j < nums.get(i); j++){
                if(used[j]){
                    continue;
                }
                s = 1;
                k = 10 - nums.size() + i;
                for(int m = 0; m < i; m++){
                    s *= k;
                    k--;
                }
                res += s;
            }
            if(used[nums.get(i)]){
                break;
            }
            if(i == 0 && !used[nums.get(i)]){
                res++;
            }
            used[nums.get(i)] = true;
        }
        return res;
    }
}
