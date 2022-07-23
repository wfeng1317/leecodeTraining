package com.leetcode.test.code1124;

import java.util.HashMap;

public class Dalao01 {

    public int longestWPI(int[] hours) {
        int sum = 0;
        int maxLen = 0;
        // 构造前缀和
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                sum++;
            }
            else {
                sum--;
            }
            hours[i] = sum;
        }
        // 如果劳累的天数大于休闲的天数，那么全部都是劳累的
        if(sum > 0){return hours.length;}
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 需要记录一个起点，起点为-1
        map.put(0, -1);
        for (int i = 0; i < hours.length; i++) {
            if (map.containsKey(hours[i] - 1)) {
                maxLen = Math.max(maxLen, i - map.get(hours[i] - 1));
            }
            if(!map.containsKey(hours[i])){
                map.put(hours[i], i);
            }
        }
        return maxLen;
    }

}
