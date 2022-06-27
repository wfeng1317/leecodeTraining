package com.leetcode.test.code1577;


import java.util.HashMap;
import java.util.Map;

public class Me {
    public int numTriplets(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2=  nums2.length;
        int res = 0;
        Map<Long, Integer> map1 = new HashMap<>();
        Map<Long, Integer> map2 = new HashMap<>();
        long temp = 0L;
        for(int i = 0; i < n1; i++){
            for(int j = i + 1; j < n1; j++){
                temp = (long)nums1[i] * (long)nums1[j];
                map1.put(temp, map1.getOrDefault(temp, 0) + 1);
            }
        }
        for(int i = 0; i < n2; i++){
            temp = (long)nums2[i] * (long)nums2[i];
            if(map1.containsKey(temp)){
                res += map1.get(temp);
            }
        }
        for(int i = 0; i < n2; i++){
            for(int j = i + 1; j < n2; j++){
                temp = (long)nums2[i] * (long)nums2[j];
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
            }
        }
        for(int i = 0; i < n1; i++){
            temp = (long)nums1[i] * (long)nums1[i];
            if(map2.containsKey(temp)){
                res += map2.get(temp);
            }
        }
        return res;
    }
}
