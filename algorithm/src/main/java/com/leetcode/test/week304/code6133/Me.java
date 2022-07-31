package com.leetcode.test.week304.code6133;

public class Me {

    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int i = 0;
        while(i * (i + 1) / 2 <= n){
            i++;
        }
        return i - 1;

    }
}
