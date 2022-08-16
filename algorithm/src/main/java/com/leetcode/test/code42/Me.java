package com.leetcode.test.code42;

public class Me {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int left = 1;
        int right = n - 2;
        int res = 0;
        while(left <= right){
            if(leftMax < rightMax){
                //若左边更小
                res += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            }else if(leftMax > rightMax){
                //若右边更小
                res += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }else{
                //两边相等，同时结算
                res += Math.max(0, leftMax - height[left]);
                res += Math.max(0, rightMax - height[right]);
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if(left == right){
                    res -= Math.max(0, leftMax - height[left]);
                }
                left++;
                right--;
            }
        }
        return res;
    }
}
