package com.leetcode.test.code66;

public class Me {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] res = new int[n];
        int plus = 1;
        int i = n - 1;
        while(i >= 0){
            if(digits[i] + plus > 9){
                res[i] = digits[i] + plus - 10;
            }else{
                res[i] = digits[i] + plus;
                plus = 0;
            }
            i--;
        }
        if(plus == 1){
            int[] res1 = new int[n + 1];
            res1[0] = 1;
            return res1;
        }else{
            return res;
        }
    }
}
