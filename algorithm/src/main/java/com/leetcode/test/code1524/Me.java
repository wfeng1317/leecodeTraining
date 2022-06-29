package com.leetcode.test.code1524;

public class Me {

    public int numOfSubarrays(int[] arr) {
        long mod = 1000000007L;
        //偶数不会改变奇偶性
        int n = arr.length;
        long res = 0L;
        //记录以每个位置结尾的和为奇数的子数组个数
        long oddArrs1 = 0;
        long evenArrs1 = 0;
        long oddArrs2 = 0;
        long evenArrs2 = 0;
        //到i为止所有的和为偶数的子数组以及和为奇的子数组
        for(int i = 0; i < n; i++){
            if((arr[i] & 1) == 1){//当前数是奇数
                oddArrs2 = evenArrs1 + 1;
                evenArrs2 = oddArrs1;
            }else{
                evenArrs2 = evenArrs1 + 1;
                oddArrs2 = oddArrs1;
            }
            res = (res + oddArrs2) % mod;
            oddArrs1 = oddArrs2;
            evenArrs1 = evenArrs2;
        }
        return (int) res;
    }
}
