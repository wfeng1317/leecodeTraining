package com.leetcode.test.code825;

public class NewMe {

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
        for(int i = 1; i <= 121; i++){
            prefixSum[i] = prefixSum[i - 1] + eachAgeCount[i - 1];
        }
        for(int i = 15; i <= 120; i++){
            if(eachAgeCount[i] > 0){
                res += eachAgeCount[i] * (prefixSum[i + 1] - prefixSum[(i >> 1) + 7 + 1] - 1);
            }
        }
        return res;
    }
}
