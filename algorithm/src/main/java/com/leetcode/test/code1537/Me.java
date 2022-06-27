package com.leetcode.test.code1537;

public class Me {

    public int maxSum(int[] nums1, int[] nums2) {
        long mod = 1000000007L;
        int n1 = nums1.length;
        int n2 = nums2.length;
        long[] preSum1 = new long[n1];
        long[] preSum2 = new long[n2];
        //先得到俩数组的前缀和
        preSum1[0] = nums1[0];
        for(int i = 1; i < n1; i++){
            preSum1[i] = preSum1[i - 1] + nums1[i];
        }
        preSum2[0] = nums2[0];
        for(int i = 1; i < n2; i++){
            preSum2[i] = preSum2[i - 1] + nums2[i];
        }
        int i1 = 0;
        int i2 = 0;
        int pre1 = -1;
        int pre2 = -1;
        long p1 = 0L;
        long p2 = 0L;
        long res = 0L;
        while(i1 < n1 && i2 < n2){
            //遇到相等值之前的最大路径和更大的最为路径
            if(nums1[i1] < nums2[i2]){
                i1++;
            }else if(nums1[i1] > nums2[i2]){
                i2++;
            }else{//相等时计算最长路径
                p1 = pre1 == -1 ? preSum1[i1] : preSum1[i1] - preSum1[pre1];
                p2 = pre2 == -1 ? preSum2[i2] : preSum2[i2] - preSum2[pre2];
                pre1 = i1;
                pre2 = i2;
                i1++;
                i2++;
                res += p1 > p2 ? p1 : p2;
            }
        }
        p1 = pre1 == -1 ? preSum1[n1 - 1] : preSum1[n1 - 1] - preSum1[pre1];
        p2 = pre2 == -1 ? preSum2[n2 - 1] : preSum2[n2 - 1] - preSum2[pre2];
        res += p1 > p2 ? p1 : p2;
        return (int) (res % mod);
    }
}
