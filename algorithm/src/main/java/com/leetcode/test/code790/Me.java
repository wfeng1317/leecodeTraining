package com.leetcode.test.code790;

import java.util.HashMap;
import java.util.Map;

public class Me {
    long mod = 1000000007;
    public int numTilings(int n) {
        Map<String, Long> dp = new HashMap<>();
        return (int) (f(n, n, dp) % mod);
    }
    public long f(int upRest, int downRest, Map<String, Long> dp){
        if(upRest < 0 || downRest < 0){
            return -1;
        }
        String target = upRest + "_" + downRest;
        if(dp.containsKey(target)){
            return dp.get(target);
        }
        long res = 0;
        if(upRest == 0){
            res = (downRest & 1) == 1 ? -1 : 1;
            dp.put(target, res);
            return dp.get(target);
        }
        if(downRest == 0){
            res = (upRest & 1) == 1 ? -1 : 1;
            dp.put(target, res);
            return dp.get(target);
        }

        long p1 = 0;
        long p2 = 0;
        long p3 = 0;
        long p4 = 0;
        if(upRest == downRest){
            p1 = f(upRest - 1, downRest - 1, dp);//1 1
            res = p1 != -1 ? res + p1 : res;
            p2 = f(upRest - 2, downRest - 2, dp);//2 2
            res = p2 != -1 ? res + p2 : res;
            p3 = f(upRest - 2, downRest - 1, dp);//2 1
            res = p3 != -1 ? res + p3 : res;
            p4 = f(upRest - 1, downRest - 2, dp);//1 2
            res = p4 != -1 ? res + p4 : res;
        }else if(upRest == downRest + 1){//上比下多1
            p1 = f(upRest - 2, downRest - 1, dp);//2 1
            res = p1 != -1 ? res + p1 : res;
            p2 = f(upRest - 2, downRest, dp);//2 0
            res = p2 != -1 ? res + p2 : res;
        }else{//上比下少1
            p1 = f(upRest - 1, downRest - 2, dp);//1 2
            res = p1 != -1 ? res + p1 : res;
            p2 = f(upRest, downRest - 2, dp);//0 2
            res = p2 != -1 ? res + p2 : res;
        }
        dp.put(target, res);
        return (int) (res % mod);
    }
}
