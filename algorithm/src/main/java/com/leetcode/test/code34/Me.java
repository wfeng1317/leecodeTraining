package com.leetcode.test.code34;

public class Me {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return new int[]{-1, -1};
        }
        int[] totalRes = new int[2];
        int left = 0;
        int right = n - 1;
        int res = -1;
        int mid = 0;
        //第一遍找到小于target最右的位置
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] < target){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        totalRes[0] = res;
        left = 0;
        right = n - 1;
        res = n;
        mid = 0;
        //第二遍找到大于target最左的位置
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] > target){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        totalRes[1] = res;
        //全是target
        if(totalRes[0] == -1 && totalRes[1] == n){
            totalRes[0] = 0;
            totalRes[1] = n - 1;
            return totalRes;
        }
        if(totalRes[0] + 1 == totalRes[1]){
            totalRes[0] = -1;
            totalRes[1] = -1;
            return totalRes;
        }
        totalRes[0]++;
        totalRes[1]--;
        return totalRes;
    }
}
