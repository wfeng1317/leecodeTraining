package com.leetcode.test.code825;

public class Me {

    public int numFriendRequests(int[] ages) {
        //前缀和
        int N = ages.length;
        if(N == 1){
            return 0;
        }
        int res = 0;
        int[] eachAgeCount = new int[122];
        int[] prefixSum = new int[122];
        for(int i = 0; i < N; i++){
            eachAgeCount[ages[i]]++;
        }
        int prefix = 0;
        for(int i = 1; i <= 121; i++){
            prefixSum[i] = prefix;
            prefix += eachAgeCount[i];
        }
        int small = 0;
        int big = 0;
        for(int i = 0; i < N; i++){
            if(ages[i] < 15){
                continue;
            }
            small = (ages[i] >> 1) + 7 + 1;
            big = ages[i] + 1;
            res += prefixSum[big] - prefixSum[small] - 1;
        }
        return res;
    }
}
