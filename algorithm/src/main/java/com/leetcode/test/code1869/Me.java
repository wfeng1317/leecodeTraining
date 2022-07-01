package com.leetcode.test.code1869;

public class Me {
    public boolean checkZeroOnes(String s) {
        int n = s.length();
        int res0 = 0;
        int res1 = 0;
        int count0 = 0;
        int count1 = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                count0++;
                res1 = Math.max(res1, count1);
                count1 = 0;
            }else{
                count1++;
                res0 = Math.max(res0, count0);
                count0 = 0;
            }
        }
        if(s.charAt(n - 1) == '0'){
            res0 = Math.max(res0, count0);
        }else{
            res1 = Math.max(res1, count1);
        }
        return res1 > res0;

    }
}
