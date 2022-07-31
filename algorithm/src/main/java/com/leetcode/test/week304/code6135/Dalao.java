package com.leetcode.test.week304.code6135;

public class Dalao {

    public int longestCycle(int[] edges) {
        int n = edges.length, ans = -1;
        int[] time = new int[n];
        for (int i = 0, clock = 1; i < n; ++i) {
            if (time[i] > 0) continue;
            for (int x = i, start_time = clock; x >= 0; x = edges[x]) {
                if (time[x] > 0) { // 重复访问
                    if (time[x] >= start_time) // 找到了一个新的环
                        ans = Math.max(ans, clock - time[x]);
                    break;
                }
                time[x] = clock++;
            }
        }
        return ans;
    }
}
