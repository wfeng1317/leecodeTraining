package com.leetcode.test.code1558;

public class Me {

    public int minOperations(int[] nums) {
        //找到数组中最大值
        //每个大于0的数都要加1
        int max = 0;
        int allPlus = 0;
        int leftOne = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                continue;
            }
            int[] curRes = f(nums[i]);
            max = Math.max(max, curRes[0]);
            allPlus += curRes[1];
        }
        return allPlus + max;
    }

    //找到最左的1
    public int[] f(int num){
        int[] res = new int[] {0, 0};
        while(num != 0){
            if((num & 1) == 1){
                num -= 1;
                res[1]++;
            }else{
                num >>= 1;
                res[0]++;
            }
        }
        return res;
    }
}
