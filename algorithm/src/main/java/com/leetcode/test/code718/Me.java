package com.leetcode.test.code718;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Me {
    int n1 = 0;
    int n2 = 0;
    public int findLength(int[] nums1, int[] nums2) {
        n1 = nums1.length;
        n2 = nums2.length;
        int res = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n2; i++){
            if(!map.containsKey(nums2[i])){
                map.put(nums2[i], new ArrayList<Integer>());
            }
            map.get(nums2[i]).add(i);
        }
        List<Integer> temp = null;
        for(int i = 0; i < n1; i++){
            if(!map.containsKey(nums1[i])){
                continue;
            }
            temp = map.get(nums1[i]);
            for(int j = 0; j < temp.size(); j++){
                res = Math.max(res, f(nums1, nums2, i, temp.get(j), res));
            }
        }
        return res;
    }

    public int f(int[] nums1, int[] nums2, int i, int j, int res){
        if(n1 - i <= res || n2 - j <= res){
            return -1;
        }
        int resTemp = 0;
        while(i < n1 && j < n2){
            if(nums1[i] != nums2[j]){
                break;
            }
            resTemp++;
            i++;
            j++;
        }
        return resTemp;
    }
}
