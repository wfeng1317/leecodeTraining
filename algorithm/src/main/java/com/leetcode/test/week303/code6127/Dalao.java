package com.leetcode.test.week303.code6127;

import java.util.Arrays;
import java.util.HashSet;

public class Dalao {
    public long countExcellentPairs(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long map[] = new long[30], count = 0;
        for (int num : nums) {
            map[Integer.bitCount(num)] += set.add(num) ? 1 : 0;
        }
        System.out.println(Arrays.toString(map));
        for (int i = 0; i < 30; i++) {
            for (int j = Math.max(0, k - i); j < 30; j++) {
                count += map[i] * map[j];
            }
        }
        return count;
    }
}
