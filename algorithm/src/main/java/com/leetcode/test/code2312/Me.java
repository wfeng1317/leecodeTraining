package com.leetcode.test.code2312;

import java.util.*;

/**
 * 55/60
 */
public class Me {

    public long sellingWood(int m, int n, int[][] prices) {
        Map<Integer, List<List<Long>>> heightMap = new HashMap<>();
        Map<Integer, List<List<Long>>> weightMap = new HashMap<>();
        for(int[] price : prices){
            if(!heightMap.containsKey(price[0])){
                heightMap.put(price[0], new ArrayList<>());
            }
            List<Long> hp = new ArrayList<>(2);
            hp.add((long)price[1]);
            hp.add((long)price[2]);
            heightMap.get(price[0]).add(hp);

            if(!weightMap.containsKey(price[1])){
                weightMap.put(price[1], new ArrayList<>());
            }
            List<Long> wp = new ArrayList<>(2);
            wp.add((long)price[0]);
            wp.add((long)price[2]);
            weightMap.get(price[1]).add(wp);
        }
        //先水平切再垂直切
        //找到每个高度的最大收益
        List<List<Long>> eachHeight = new ArrayList<>();
        Set<Integer> heightKeys = heightMap.keySet();
        for(Integer heightKey : heightKeys){
            List<Long> allHP = new ArrayList<>(2);
            allHP.add(heightKey.longValue());
            allHP.add(process(heightMap.get(heightKey), n));
            eachHeight.add(allHP);
        }
        //先垂直切再水平切
        //找到每个宽度的最大收益
        List<List<Long>> eachWeight = new ArrayList<>();
        Set<Integer> weightKeys = weightMap.keySet();
        for(Integer weightKey : weightKeys){
            List<Long> allWP = new ArrayList<>(2);
            allWP.add(weightKey.longValue());
            allWP.add(process(weightMap.get(weightKey), m));
            eachWeight.add(allWP);
        }
        return Math.max(process(eachHeight, m), process(eachWeight, n));
    }

    //在给定allGoods的货物中，当前到达的位置cur找到还剩rest的最大价值
    public long process(List<List<Long>> allGoods, int rest){
        int as = allGoods.size();
        long[][] dp = new long[as + 1][rest + 1];
        for(int i = as - 1; i >= 0; i--){
            for(int j = 0; j <= rest; j++){
                int count = 0;
                while(j - count * allGoods.get(i).get(0) >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][(int)(j - count * allGoods.get(i).get(0))] + count * allGoods.get(i).get(1));
                    count++;
                }
            }
        }
        long res = 0L;
        for(int i = 0; i < as; i++){
            res = Math.max(res, dp[i][rest]);
        }
        return res;
    }
}
