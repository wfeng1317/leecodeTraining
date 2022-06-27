package com.leetcode.test.week299.code5229;

import java.util.ArrayList;
import java.util.List;

public class Me {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pre1 = new int[n];
        pre1[0] = nums1[0];
        int[] pre2 = new int[n];
        pre2[0] = nums2[0];
        for(int i = 1; i < n; i++){
            pre1[i] = pre1[i - 1] + nums1[i];
            pre2[i] = pre2[i - 1] + nums2[i];
        }
        int res = Math.max(pre1[n - 1], pre2[n - 1]);
        int left = 0;
        int right = 0;
        int start = 0;
        List<Integer> change = new ArrayList<>();//新的开始
        change.add(0);
        while(start < n){
            if(nums1[start] > nums2[start]){
                while(start < n && nums1[start] >= nums2[start]){
                    start++;
                }
                change.add(start);
            }else if(nums1[start] < nums2[start]){
                while(start < n && nums1[start] <= nums2[start]){
                    start++;
                }
                change.add(start);
            }else{
                start++;
            }
        }
        int cn = change.size();
        start = 0;
        for(; start < cn; start++){
            left = change.get(start);
            int i = 1;
            while(start + i < cn){
                right = change.get(start + i);
                int p1 = pre1[n - 1] - pre1[right - 1] + pre2[right - 1];
                if(left != 0){
                    p1 += pre1[left - 1];
                    p1 -= pre2[left - 1];
                }
                int p2 = pre2[n - 1] - pre2[right - 1] + pre1[right - 1];
                if(left != 0){
                    p2 += pre2[left - 1];
                    p2 -= pre1[left - 1];
                }

                res = Math.max(res, Math.max(p1, p2));
                i += 2;
            }
        }
        return res;
    }
}
