package com.leetcode.test.code438;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Me02 {

    public List<Integer> findAnagrams(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        List<Integer> res = new ArrayList<>();
        if(sn < pn){
            return res;
        }
        //首先记录p中的所有字符
        // Map<Character, Integer> pMap = new HashMap<>();
        int[] pStr = new int[26];
        Set<Character> set = new HashSet<>();
        int zhonglei = 0;
        for(int i = 0; i < pn; i++){
            if(pStr[p.charAt(i) - 'a'] == 0){
                zhonglei++;
                set.add(p.charAt(i));
            }
            pStr[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = pn - 1;
        for(int i = 0; i <= right; i++){
            if(set.contains(s.charAt(i))){
                pStr[s.charAt(i) - 'a']--;
                if(pStr[s.charAt(i) - 'a'] == 0){
                    zhonglei--;
                }
            }
        }
        if(zhonglei == 0){
            res.add(left);
        }
        right++;
        while(right < sn){
            if(set.contains(s.charAt(left))){
                if(pStr[s.charAt(left) - 'a'] == 0){
                    zhonglei++;
                }
                pStr[s.charAt(left) - 'a']++;
            }
            if(set.contains(s.charAt(right))){
                if(pStr[s.charAt(right) - 'a'] == 1){
                    zhonglei--;
                }
                pStr[s.charAt(right) - 'a']--;
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
