package com.leetcode.test.code1417;

import java.util.ArrayList;
import java.util.List;

public class Me {
    public String reformat(String s) {
        int n = s.length();
        if(n == 1){
            return s;
        }
        List<Character> nums = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                nums.add(s.charAt(i));
            }else{
                letters.add(s.charAt(i));
            }
        }
        int nn = nums.size();
        int ln = letters.size();
        if(nn == 0 || ln == 0){
            return "";
        }
        if(nn - ln >= 2 || ln - nn >= 2){
            return "";
        }
        StringBuilder res = new StringBuilder(n);
        if(ln < nn){
            res.append(nums.get(0));
            for(int i = 0; i < ln; i++){
                res.append(letters.get(i));
                res.append(nums.get(i + 1));
            }
        }else if(nn < ln){
            res.append(letters.get(0));
            for(int i = 0; i < nn; i++){
                res.append(nums.get(i));
                res.append(letters.get(i + 1));
            }
        }else{
            for(int i = 0; i < nn; i++){
                res.append(nums.get(i));
                res.append(letters.get(i));
            }
        }
        return res.toString();
    }
}
