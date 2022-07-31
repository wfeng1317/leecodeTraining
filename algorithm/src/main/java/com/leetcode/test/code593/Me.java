package com.leetcode.test.code593;

import java.util.HashSet;
import java.util.Set;

public class Me {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        //对角线相等的且四条边相等
        set.add((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
        set.add((p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]));
        set.add((p1[0] - p4[0]) * (p1[0] - p4[0]) + (p1[1] - p4[1]) * (p1[1] - p4[1]));
        set.add((p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1]));
        set.add((p4[0] - p2[0]) * (p4[0] - p2[0]) + (p4[1] - p2[1]) * (p4[1] - p2[1]));
        set.add((p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1]));
        return set.size() == 2 && !set.contains(0);
    }
}
