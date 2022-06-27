package com.leetcode.test.code718;

public class Me02 {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int res = 0;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int i = n1 - 1; i >= 0; i--){
            for(int j = n2 - 1; j >= 0; j--){
                if(nums1[i] == nums2[j]){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

}
