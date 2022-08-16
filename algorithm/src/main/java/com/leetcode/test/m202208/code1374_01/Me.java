package com.leetcode.test.m202208.code1374_01;

public class Me {
    public String generateTheString(int n) {
        String res = "";
        //若n为奇数，则需要奇数种字符
        if(n % 2 == 1){
            for(int i = 0; i < n; i++){
                res += "a";
            }
        }else{
            for(int i = 0; i < n - 1; i++){
                res += "a";
            }
            res += "b";
        }
        return res;
    }
}
