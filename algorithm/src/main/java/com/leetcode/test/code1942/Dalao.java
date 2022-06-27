package com.leetcode.test.code1942;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Dalao {

    public int smallestChair(int[][] times, int targetFriend) {
        int len = times.length;
        int[][] t = new int[len][3];
        for (int i = 0; i < len; i++) {
            t[i][0] = times[i][0];
            t[i][1] = times[i][1];
            t[i][2] = i;
        }
        Arrays.sort(t, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        for (int i = 0; i < len; i++) {
            int[] cur = t[i];
            int arrivali = cur[0], leavingi = cur[1], index = cur[2];
            while (!queue.isEmpty() && queue.peek()[0] <= arrivali) {
                int[] leave = queue.poll();
                ts.add(leave[1]);
            }
            int low = ts.first();
            if (index == targetFriend) {
                return low;
            }
            ts.remove(low);
            if (ts.isEmpty()) {
                ts.add(low + 1);
            }
            queue.add(new int[]{leavingi, low});
        }
        return -1;
    }
}

