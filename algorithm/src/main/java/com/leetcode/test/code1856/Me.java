package com.leetcode.test.code1856;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用前缀和与单调栈
 * 前缀和数组最好使用long类型的数组
 */
public class Me {

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long res = 0L;
        long mod = 1000000007L;
        //前缀和
        long[] prefix = new long[n + 1];
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        //找到每个位置左边比他小最近的以及右边比他小最近的
        int[] stack = new int[n + 1];
        int[] left = new int[n];
        int[] right = new int[n];
        int size = 0;
        List<Integer> deng = new ArrayList<>();
        for(int i = 0; i < n; i++){
            //如果当前位置比栈顶大直接入栈，若小则弹出栈顶元素，继续判断
            while(size > 0 && nums[i] < nums[stack[size - 1]]){
                //弹出栈顶元素
                right[stack[size - 1]] = i;
                deng.add(stack[size - 1]);
                size--;
                if(size == 0 || nums[stack[size - 1]] < nums[stack[size]]){
                    //给所有deng里的元素左边赋值
                    int min = size == 0 ? -1 : stack[size - 1];
                    for(Integer j : deng){
                        left[j] = min;
                    }
                    deng.clear();
                }
            }
            stack[size] = i;
            size++;
        }
        //最后弹出剩余的元素
        while(size > 0){
            int pop = stack[size - 1];
            right[pop] = n;
            deng.add(pop);
            size--;
            if(size == 0 || nums[stack[size - 1]] < nums[pop]){
                //给所有deng的左边赋值
                for(Integer j : deng){
                    int min = size == 0 ? -1 : stack[size - 1];
                    left[j] = min;
                }
                deng.clear();
            }
        }
        //收集每个位置的答案
        for(int i = 0; i < n; i++){
            res = Math.max(res, nums[i] * (prefix[right[i]] - prefix[left[i] + 1]));
        }
        return (int)(res % mod);
    }
}
