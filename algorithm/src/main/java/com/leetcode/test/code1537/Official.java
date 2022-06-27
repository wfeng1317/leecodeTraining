package com.leetcode.test.code1537;

public class Official {
    public int maxSum(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int m = nums1.length;
        int n = nums2.length;
        long best1 = 0, best2 = 0;
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    best1 += nums1[i];
                    ++i;
                } else if (nums1[i] > nums2[j]) {
                    best2 += nums2[j];
                    ++j;
                } else {
                    long best = Math.max(best1, best2) + nums1[i];
                    best1 = best2 = best;
                    ++i;
                    ++j;
                }
            } else if (i < m) {
                best1 += nums1[i];
                ++i;
            } else if (j < n) {
                best2 += nums2[j];
                ++j;
            }
        }
        return (int) (Math.max(best1, best2) % MOD);
    }
}
