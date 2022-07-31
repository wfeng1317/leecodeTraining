package com.leetcode.test.week304.code6135;

import java.util.HashSet;
import java.util.Set;

public class Me {

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] gd = new boolean[n];
        Set<Integer> set = new HashSet<>();
        int max = -1;
        for(int i = 0; i < n; i++){
            if(gd[i]){
                continue;
            }
            int s = i;
            boolean[] d = new boolean[n];
            while(s != -1 && !gd[s] && !d[s]){
                gd[s] = true;
                d[s] = true;
                s = edges[s];
            }
            if(s != -1 && d[s] && !set.contains(s)){
                //环
                int loopS = s;
                set.add(loopS);
                gd[loopS] = true;
                int res = 0;
                while(edges[loopS] != s){
                    loopS = edges[loopS];
                    set.add(loopS);
                    gd[loopS] = true;
                    res++;
                }
                max = Math.max(max, res + 1);
            }

        }
        return max;

    }
}
