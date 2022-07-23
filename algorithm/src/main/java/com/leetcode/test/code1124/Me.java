package com.leetcode.test.code1124;

import java.util.Stack;

/**
 * 参考
 */
public class Me {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int res = 0;
        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= n; i++){
            if(stack.isEmpty() || preSum[i] < preSum[stack.peek()]){
                stack.push(i);
            }
        }
        for(int i = n; i > 0; i--){
            while(!stack.isEmpty() && preSum[i] > preSum[stack.peek()]){
                res = Math.max(res, i - stack.peek());
                stack.pop();
            }
            if(stack.isEmpty()){
                break;
            }
        }
        return res;

    }
}
