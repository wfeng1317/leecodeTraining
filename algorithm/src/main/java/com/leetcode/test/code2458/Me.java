package com.leetcode.test.code2458;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/0ynMMM/
 */
public class Me {
    /**
     * 先找左边比i小且离i最近的以及右边比i小且离i最近的
     * 最后再汇总结果
     * @param heights
     * @return
     */
    public int largestRectangleArea01(int[] heights) {
        int n = heights.length;
        //找到左边离我最近的比我小的
        int[] left = new int[n];
        Deque<Integer> leftStack = new LinkedList<>();
        leftStack.addLast(-1);
        int cur = 0;
        for (int i = 0; i < n; i++) {
            while (leftStack.getLast() != -1 && heights[i] <= heights[leftStack.getLast()]) {
                cur = leftStack.removeLast();
                left[cur] = leftStack.getLast();
            }
            leftStack.addLast(i);
        }
        while (leftStack.getLast() != -1) {
            cur = leftStack.removeLast();
            left[cur] = leftStack.getLast();
        }
        //再找右边离我最近的比我小的
        int[] right = new int[n];
        Deque<Integer> rightStack = new LinkedList<>();
        rightStack.addLast(-1);
        for (int i = n - 1; i >= 0; i--) {
            while (rightStack.getLast() != -1 && heights[i] <= heights[rightStack.getLast()]) {
                cur = rightStack.removeLast();
                right[cur] = rightStack.getLast();
            }
            rightStack.addLast(i);
        }
        while (rightStack.getLast() != -1) {
            cur = rightStack.removeLast();
            right[cur] = rightStack.getLast();
        }
        //遍历得到结果
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            right[i] = right[i] == -1 ? n : right[i];
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }


    /**
     * 左边比i小的就是入栈时的栈顶元素，右边比i小的就是使i出栈的元素
     * 此方法只需遍历一次
     * @param heights
     * @return
     */
    public int largestRectangleArea02(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        Deque<Integer> leftStack = new LinkedList<>();
        leftStack.addLast(-1);
        int cur = 0;
        int max = Integer.MIN_VALUE;
        //左边比i小的就是入栈时的栈顶元素，右边比i小的就是使i出栈的元素
        for(int i = 0; i < n; i++){
            while(leftStack.getLast() != -1 && heights[i] <= heights[leftStack.getLast()]){
                cur = leftStack.removeLast();
                max = Math.max(max, heights[cur] * (i - left[cur] - 1));
            }
            left[i]= leftStack.getLast();
            leftStack.addLast(i);
        }
        while(leftStack.getLast() != -1){
            cur = leftStack.removeLast();
            max = Math.max(max, heights[cur] * (n - left[cur] - 1));
        }
        return max;
    }
}
