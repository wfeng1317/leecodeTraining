package com.leetcode.test.code2138;

public class Me {

    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int resLen = (n % k) == 0 ? n / k : n / k + 1;
        String[] res = new String[resLen];
        int i = 0;
        while(i < resLen - 1){
            res[i] = s.substring(k * i, k* (i + 1));
            i++;
        }
        String rest = s.substring((resLen - 1) * k);
        while(rest.length() < k){
            rest += String.valueOf(fill);
        }
        res[resLen - 1] = rest;
        return res;
    }
}
