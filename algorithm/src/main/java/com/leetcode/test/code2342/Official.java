package com.leetcode.test.code2342;

public class Official {

    public int maximumSum(int[] nums) {
        int n=nums.length,max=-1;
        int[][] p=new int[91][2];
        for(int i=0;i<n;i++){
            int sum=0,num=nums[i];
            while(num!=0){
                sum+=num%10;
                num/=10;
            }
            num=nums[i];
            if(p[sum][1]<=num){
                p[sum][1]=num;
                if(p[sum][0]<num){
                    p[sum][1]=p[sum][0];
                    p[sum][0]=num;
                }
            }
            if(p[sum][0]!=0&&p[sum][1]!=0){
                max=Math.max(max,p[sum][0]+p[sum][1]);
            }
        }
        return max;
    }
}
