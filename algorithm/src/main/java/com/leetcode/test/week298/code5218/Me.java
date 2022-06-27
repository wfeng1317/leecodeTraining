package com.leetcode.test.week298.code5218;

import java.util.HashMap;
import java.util.Map;

public class Me {

    public int minimumNumbers(int num, int k) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        return process(num, k, dp);
    }

    public int process(int num, int k, Map<Integer, Integer> dp){
        if(dp.containsKey(num)){
            return dp.get(num);
        }
        if(num < k){
            dp.put(num, -1);
            return dp.get(num);
        }
        int i = k == 0 ? 1 : 0;
        int res = Integer.MAX_VALUE;
        while(k + i * 10 <= num){
            int next = process(num - (k + i * 10), k, dp);
            if(next != -1){
                res = Math.min(next + 1, res);
            }
            i++;
        }
        dp.put(num, res == Integer.MAX_VALUE ? -1 : res);
        return dp.get(num);
    }
}
