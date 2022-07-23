package com.leetcode.test.code76;

import java.util.HashMap;
import java.util.Map;

public class Me {

    public String minWindow(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        if(sn < tn){
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        //获取 t 中所有字符
        char cur = ' ';
        for(int i = 0; i < tn; i++){
            cur = t.charAt(i);
            if(tMap.containsKey(cur)){
                tMap.put(cur, tMap.get(cur) + 1);
            }else{
                tMap.put(cur, 1);
            }
        }
        int tCategory = tMap.size();
        int min = sn + 1;
        int minLeft = 0;
        int left = 0;
        int right = -1;
        while(right < sn){
            //判断 left 与 right 中包含的区间是否能满足情况
            if(tCategory > 0){//当还有 t 需满足，往右移
                right++;
                if(right == sn){
                    break;
                }
                cur = s.charAt(right);
                if(tMap.containsKey(cur)){
                    tMap.put(cur, tMap.get(cur) - 1);
                    if(tMap.get(cur) == 0){
                        tCategory--;
                    }
                }
            }else{

                //如果t已被全部满足
                //left移到最右的位置
                while(left <= right){
                    cur = s.charAt(left);
                    if(tMap.containsKey(cur)){
                        if(tMap.get(cur) == 0){
                            break;
                        }
                        tMap.put(cur, tMap.get(cur) + 1);
                    }
                    left++;
                }
                //left到达最右，记录结果
                if(right - left + 1 < min){
                    min = right - left + 1;
                    minLeft = left;
                }
                //二者均往右移1
                cur = s.charAt(left);
                tMap.put(cur, tMap.get(cur) + 1);
                tCategory++;
                left++;
                right++;
                if(right == sn){
                    break;
                }
                cur = s.charAt(right);
                if(tMap.containsKey(cur)){
                    tMap.put(cur, tMap.get(cur) - 1);
                    if(tMap.get(cur) == 0){
                        tCategory--;
                    }
                }
            }
        }
        if(min == sn + 1){
            return "";
        }else{
            return s.substring(minLeft, minLeft + min);
        }
    }
}
