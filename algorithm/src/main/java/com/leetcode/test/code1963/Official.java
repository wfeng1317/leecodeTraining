package com.leetcode.test.code1963;

public class Official {
    public int minSwaps(String s) {
        int n = s.length();
        int cnt = 0;
        int minCnt=  0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '['){
                cnt++;
            }else{
                cnt--;
                minCnt = Math.min(minCnt, cnt);
            }
        }
        return (-minCnt + 1) / 2;
    }
}
