package com.leetcode.test.code647;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Me {

    public int countSubstrings(String s) {
        //将所有位置结尾时的回文子串个数叠加
        //先记录所有字符的位置
        Map<Character, List<Integer>> map = new HashMap<>();
        List<Integer> list = null;
        char cur = ' ';
        for(int i = 0; i < s.length(); i++){
            cur = s.charAt(i);
            if(map.containsKey(cur)){
                map.get(cur).add(i);
            }else{
                list = new ArrayList<>();
                list.add(i);
                map.put(cur, list);
            }
        }
        //对于每一个位置，计算出回文子串个数
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            cur = s.charAt(i);
            list = map.get(cur);
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) > i){
                    break;
                }
                if(process(s, list.get(j), i)){
                    res++;
                }
            }
        }
        return res;
    }

    public boolean process(String s, int left, int right){
        if(left == right){
            return true;
        }
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
