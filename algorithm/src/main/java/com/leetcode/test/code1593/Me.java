package com.leetcode.test.code1593;

import java.util.HashSet;
import java.util.Set;

public class Me {
    int res = 0;
    public int maxUniqueSplit(String s) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        f(0, 0, set, n, s);
        return res;
    }

    public void f(int start, int cur, Set<String> set, int n, String s){
        if(cur == n - 1){
            if(!set.contains(s.substring(start))){
                res = Math.max(res, set.size() + 1);
            }
            return;
        }
        String pre = s.substring(start, cur + 1);


        //第一种情况，set里没有，则可选择切或不切
        if(!set.contains(pre)){
            //切
            set.add(pre);
            f(cur + 1, cur + 1, set, n, s);
            set.remove(pre);
        }
        //不管set里有没有，都可以选择不切
        f(start, cur + 1, set, n, s);
    }
}
