package com.leetcode.test.code1535;

public class Me {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int max = Math.max(arr[0], arr[1]);
        int count = 1;
        for(int i = 2; i < n; i++){
            if(count == k){
                return max;
            }
            if(arr[i] > max){
                count = 1;
                max = arr[i];
            }else{
                count++;
            }
        }
        return max;
    }
}
