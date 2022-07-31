package com.leetcode.test.code1331;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Me {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        //记录每一个数字的位置
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<Integer>());
            }
            map.get(arr[i]).add(i);
        }
        Set<Integer> keys = map.keySet();
        int j = 1;
        for(Integer key : keys){
            for(int i : map.get(key)){
                res[i] = j;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.getInteger("11111"));
    }
}
