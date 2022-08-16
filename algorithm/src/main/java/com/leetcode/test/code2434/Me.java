package com.leetcode.test.code2434;

public class Me {
    public int minArray(int[] numbers) {
        int min = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            min = Math.min(min, numbers[i]);
        }
        return min;
    }
}
