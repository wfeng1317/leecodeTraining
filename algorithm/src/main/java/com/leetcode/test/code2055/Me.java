package com.leetcode.test.code2055;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Me {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int sn = s.length();
        int[] ans = new int[n];
        int panzis = 0;
        Map<Integer, Integer> leftRight = new HashMap<>();
        Map<Integer, Integer> rightLeft = new HashMap<>();
        //记录每两个蜡烛之间的盘子数，以及所有蜡烛的位置
        List<Integer> candles = new ArrayList<>();
        List<Integer> disks = new ArrayList<>();
        int i = 0;
        while(i < sn && s.charAt(i) == '*'){
            i++;
        }
        if(i == sn){
            return ans;
        }
        candles.add(i);
        i++;
        for(; i < sn; i++){
            if(s.charAt(i) == '*'){
                panzis++;
            }else{
                candles.add(i);
                disks.add(panzis);
                panzis = 0;
            }
        }
        if(candles.size() == 1){
            return ans;
        }
        //计算前缀和
        int ds = disks.size();
        int[] prefixSum = new int[ds];
        prefixSum[0] = disks.get(0);
        for(int j = 1; j < ds; j++){
            prefixSum[j] = prefixSum[j - 1] + disks.get(j);
        }
        //找到每一个查询区间左边最右的蜡烛以及右边最左的蜡烛
        for(i = 0; i < n; i++){
            int left = findLeftRight(queries[i][0], leftRight, candles);
            int right = findRightLeft(queries[i][1], rightLeft, candles);
            if(left != -1 && right != -1 && right > left){
                if(right - 1 >= 0){
                    ans[i] = prefixSum[right - 1];
                }
                if(left  - 1 >= 0){
                    ans[i] -= prefixSum[left - 1];
                }
            }
        }
        return ans;
    }

    public int findLeftRight(int left, Map<Integer, Integer> leftRight, List<Integer> candles){
        if(leftRight.containsKey(left)){
            return leftRight.get(left);
        }
        int left01 = 0;
        int right01 = candles.size() - 1;
        int res = -1;
        //大于等于left的最右位置
        while(left01 <= right01){
            int middle = (left01 + right01) >> 1;
            if(candles.get(middle) >= left){
                res = middle;
                right01 = middle - 1;
            }else{
                left01 = middle + 1;
            }
        }
        leftRight.put(left, res);
        return res;
    }

    public int findRightLeft(int right, Map<Integer, Integer> rightLeft, List<Integer> candles){
        if(rightLeft.containsKey(right)){
            return rightLeft.get(right);
        }
        int left01 = 0;
        int right01 = candles.size() - 1;
        int res = -1;
        //大于等于left的最右位置
        while(left01 <= right01){
            int middle = (left01 + right01) >> 1;
            if(candles.get(middle) <= right){
                res = middle;
                left01 = middle + 1;
            }else{
                right01 = middle - 1;
            }
        }
        rightLeft.put(right, res);
        return res;
    }

}
