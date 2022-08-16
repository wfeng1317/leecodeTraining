package com.leetcode.test.code768;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 单调栈
 */
public class Official02 {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int num : arr) {
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                int mx = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(mx);
            }
        }
        return stack.size();
    }

}
