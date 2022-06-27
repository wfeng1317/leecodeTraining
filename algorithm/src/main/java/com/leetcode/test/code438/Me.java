package com.leetcode.test.code438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Me {

    public List<Integer> findAnagrams(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        List<Integer> res = new ArrayList<>();
        if(sn < pn){
            return res;
        }
        //首先记录p中的所有字符
        Map<Character, Integer> pMap = new HashMap<>();
        for(int i = 0; i < pn; i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int zhonglei = pMap.size();
        int left = 0;
        int right = pn - 1;
        for(int i = 0; i <= right; i++){
            if(pMap.containsKey(s.charAt(i))){
                pMap.put(s.charAt(i), pMap.get(s.charAt(i)) - 1);
                if(pMap.get(s.charAt(i)) == 0){
                    zhonglei--;
                }
            }
        }
        if(zhonglei == 0){
            res.add(left);
        }
        right++;
        while(right < sn){
            if(pMap.containsKey(s.charAt(left))){
                if(pMap.get(s.charAt(left)) == 0){
                    zhonglei++;
                }
                pMap.put(s.charAt(left), pMap.get(s.charAt(left)) + 1);
            }
            if(pMap.containsKey(s.charAt(right))){
                if(pMap.get(s.charAt(right)) == 1){
                    zhonglei--;
                }
                pMap.put(s.charAt(right), pMap.get(s.charAt(right)) - 1);
            }
            if(zhonglei == 0){
                res.add(left + 1);
            }
            left++;
            right++;
        }
        return res;
    }
}
