package com.leetcode.test.code1035;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Me {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        Map<String, Integer> dp = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            if(!map1.containsKey(nums1[i])){
                map1.put(nums1[i], new ArrayList<Integer>());
            }
            map1.get(nums1[i]).add(i);
        }
        for(int i = 0; i < nums2.length; i++){
            if(!map2.containsKey(nums2[i])){
                map2.put(nums2[i], new ArrayList<Integer>());
            }
            map2.get(nums2[i]).add(i);
        }
        return f(nums1, nums2, 0, 0, map1, map2, dp);

    }

    static int f(int[] nums1, int[] nums2, int s1, int s2, Map<Integer, List<Integer>> map1, Map<Integer, List<Integer>> map2, Map<String, Integer> dp){
        if(s1 == nums1.length || s2 == nums2.length){
            return 0;
        }
        String target = s1 + "_" + s2;
        if(dp.containsKey(target)){
            return dp.get(target);
        }
        int res = 0;
        List<Integer> possi = null;
        //对于nums1而言，找到nums2最近的相同数字开头
        res = Math.max(res, f(nums1, nums2, s1 + 1, s2, map1, map2, dp));
        if(map2.containsKey(nums1[s1])){
            possi = map2.get(nums1[s1]);
            for(int i = 0; i < possi.size(); i++){
                if(possi.get(i) < s2){
                    continue;
                }
                res = Math.max(res, f(nums1, nums2, s1 + 1, possi.get(i) + 1, map1, map2, dp) + 1);
                break;
            }
        }
        //对于nums2而言，找到nums1最近的相同数字开头
        res = Math.max(res, f(nums1, nums2, s1, s2 + 1, map1, map2, dp));
        if(map1.containsKey(nums2[s2])){
            possi = map1.get(nums2[s2]);
            for(int i = 0; i < possi.size(); i++){
                if(possi.get(i) < s1){
                    continue;
                }
                res = Math.max(res, f(nums1, nums2, possi.get(i) + 1, s2 + 1, map1, map2, dp) + 1);
                break;
            }
        }
        dp.put(target, res);
        return res;
    }
}
