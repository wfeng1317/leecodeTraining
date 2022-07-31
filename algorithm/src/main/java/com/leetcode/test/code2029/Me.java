package com.leetcode.test.code2029;

public class Me {
    public boolean stoneGameIX(int[] stones) {
        //将所有石子分为 0, 1, 2
        int[] allStones = new int[3];
        for(int i : stones){
            allStones[i % 3]++;
        }
        //每一个人都不会使自己当前拿到的石子价值和为3的倍数
        //判断有0无0
        return allStones[0] % 2 == 0 ? !(allStones[1] == 0 || allStones[2] == 0) : Math.abs(allStones[1] - allStones[2]) > 2;
    }
}
