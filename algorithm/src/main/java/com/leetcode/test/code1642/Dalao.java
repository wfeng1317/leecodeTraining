package com.leetcode.test.code1642;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Dalao {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> hq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 1; i < heights.length; i++) {
            int cnt = heights[i] - heights[i - 1];
            if (cnt > 0) {
                hq.add(cnt);
                bricks -= cnt;
                if (bricks < 0) {
                    if (ladders > 0) {
                        ladders--;
                        bricks += hq.poll();
                    } else return i - 1;
                }
            }
        }
        return heights.length - 1;
    }
}
