package com.leetcode.test.code2105;

public class Me {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int res = 0;
        int a = 0;
        int b = n - 1;
        int resta = capacityA;
        int restb = capacityB;
        while(a <= b){
            if(a == b){
                res = Math.max(resta, restb) < plants[a] ? res + 1 : res;
                break;
            }
            if(resta < plants[a]){
                res++;
                resta = capacityA;
            }
            if(restb < plants[b]){
                res++;
                restb = capacityB;
            }
            if(resta >= plants[a]){
                resta -= plants[a];
                a++;
            }
            if(restb >= plants[b]){
                restb -= plants[b];
                b--;
            }
        }
        return res;
    }
}
