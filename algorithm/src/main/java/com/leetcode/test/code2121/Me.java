package com.leetcode.test.code2121;

import java.util.HashMap;
import java.util.Map;

public class Me {

    public long[] getDistances(int[] arr) {
        int n =  arr.length;
        long[] res = new long[n];
        Map<Integer, long[]> map = new HashMap<>();
        long[] temp = null;
        //正向遍历所有数字，保存所有位置的累加和以及出现次数
        //0：累加和 1: 次数
        for(int i = 0; i < n; i++){
            temp = map.getOrDefault(arr[i], new long[] {0L, 0L});
            res[i] += temp[1] * i - temp[0];
            temp[0] += i;
            temp[1]++;
            map.put(arr[i], temp);
        }
        //反向遍历所有数字，保存所有位置的累加和以及出现次数
        //0：累加和 1: 次数
        map.clear();
        for(int i = n - 1; i >= 0; i--){
            temp = map.getOrDefault(arr[i], new long[] {0L, 0L});
            res[i] += temp[0] - temp[1] * i;
            temp[0] += i;
            temp[1]++;
            map.put(arr[i], temp);
        }
        return res;
    }
}
