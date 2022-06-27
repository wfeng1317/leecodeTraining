package com.leetcode.test.code2325;

import java.util.ArrayList;

public class Me {

    public int numWays(int n, int[][] relation, int k) {
        ArrayList<Integer>[] nei = new ArrayList[n];
        for(int i = 0; i < n; i++){
            nei[i] = new ArrayList<Integer>();
        }
        for(int[] r : relation){
            nei[r[0]].add(r[1]);
        }
        return f(0, k, nei);
    }

    public int f(int cur, int rest, ArrayList<Integer>[] nei){
        if(rest == 0){
            return cur == nei.length - 1 ? 1 : 0;
        }
        int res = 0;
        for(int i = 0; i < nei[cur].size(); i++){
            res += f(nei[cur].get(i), rest - 1, nei);
        }
        return res;
    }
}
