package com.leetcode.test.code768;

public class Me {
    public int maxChunksToSorted(int[] arr) {
        //找到每个数左边比他大最远的数，从它到最远位置为1块，若没有自成一块
        int n = arr.length;
        int res = 0;
        int[] zuizuo = new int[n];
        for(int i = n - 1; i >= 0; i--){
            zuizuo[i] = -1;
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] > arr[i]){
                    zuizuo[i] = j;
                }
            }
        }
        int start = n - 1;
        int end = zuizuo[n - 1];
        while(start >= end){
            if(start == end || end == -1){
                res++;
                start--;
                if(start < 0){
                    break;
                }
                end = zuizuo[start];
                continue;
            }
            start--;
            if(start < 0){
                res++;
                break;
            }
            if(zuizuo[start] != -1){
                end = Math.min(end, zuizuo[start]);
            }
        }
        return res;
    }
}
