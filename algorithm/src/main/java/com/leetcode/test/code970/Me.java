package com.leetcode.test.code970;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Me {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res01 = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        if(x == 1 && y == 1){
            if(2 <= bound){
                res.add(2);
            }
            return res;
        }
        int pre01 = 0;
        int left = 0;
        if(x != y && (x == 1 || y == 1)){
            pre01 = x < y ? y : x;
            left = 2;
            while(left <= bound){
                res.add(left);
                left = (left - 1) * pre01 + 1;
            }
            return res;
        }
        pre01 = 2;
        while(pre01 <= bound){
            res01.add(pre01);
            int pre = pre01 - 1 + y;
            left = pre01 - 1;
            while(pre <= bound){
                res01.add(pre);
                pre = (pre - left) * y + left;
            }
            pre01 = (pre01 - 1) * x + 1;
        }
        for(Integer i : res01){
            res.add(i);
        }
        return res;
    }
}
