package com.leetcode.test.code75;

public class Me {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                zero++;
            }else if(nums[i] == 1){
                one++;
            }else{
                two++;
            }
        }
        int j = 0;
        for(int i = 0; i < zero; i++){
            nums[j++] = 0;
        }
        for(int i = 0; i < one; i++){
            nums[j++] = 1;
        }
        for(int i = 0; i < two; i++){
            nums[j++] = 2;
        }

    }
}
