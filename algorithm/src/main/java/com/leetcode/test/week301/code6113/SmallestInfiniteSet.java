package com.leetcode.test.week301.code6113;

import java.util.TreeSet;

public class SmallestInfiniteSet {

    int min = 0;
    TreeSet<Integer> newAdd = null;
    public SmallestInfiniteSet() {
        min = 1;
        newAdd = new TreeSet<>();
    }

    public int popSmallest() {
        if(newAdd.size() == 0){
            return min++;
        }
        return newAdd.pollFirst();
    }

    public void addBack(int num) {
        if(num >= min){
            return;
        }
        newAdd.add(num);
    }
}
