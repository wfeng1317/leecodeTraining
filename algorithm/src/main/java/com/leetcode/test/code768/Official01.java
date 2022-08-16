package com.leetcode.test.code768;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表
 */
public class Official01 {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int res = 0;
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        for (int i = 0; i < sortedArr.length; i++) {
            int x = arr[i], y = sortedArr[i];
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 0) {
                cnt.remove(x);
            }
            cnt.put(y, cnt.getOrDefault(y, 0) - 1);
            if (cnt.get(y) == 0) {
                cnt.remove(y);
            }
            if (cnt.isEmpty()) {
                res++;
            }
        }
        return res;
    }
}
