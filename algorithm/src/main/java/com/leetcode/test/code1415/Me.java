package com.leetcode.test.code1415;

public class Me {

    public String getHappyString(int n, int k) {
        int happyCount = 3 * (1 << (n - 1));
        if(happyCount < k){
            return "";
        }
        String res = "";
        happyCount /= 3;
        if(k <= happyCount){
            res += 'a';
        }else if(k <= 2 * happyCount){
            res += 'b';
            k -= happyCount * 1;
        }else{
            res += 'c';
            k -= happyCount * 2;
        }
        int i = 1;
        while(i < n){
            happyCount /= 2;
            if(k <= happyCount){
                if(res.charAt(i - 1) == 'a'){
                    res += 'b';
                }else{
                    res += 'a';
                }
            }else{
                if(res.charAt(i - 1) == 'c'){
                    res += 'b';
                }else{
                    res += 'c';
                }
                k -= happyCount;
            }
            i++;
        }
        return res;
    }
}
