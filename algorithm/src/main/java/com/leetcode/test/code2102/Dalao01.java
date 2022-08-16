package com.leetcode.test.code2102;

import java.util.*;

/**
 * 使用双堆
 */
public class Dalao01 {
    List<String> names = new ArrayList<>();
    List<Integer> scores = new ArrayList<>();
    Comparator<Integer> comparator = Comparator.comparing(scores::get)
            .thenComparing(Comparator.comparing(names::get).reversed());
    Queue<Integer> minHeap = new PriorityQueue<>(comparator);
    Queue<Integer> maxHeap = new PriorityQueue<>(comparator.reversed());

    public Dalao01() {
    }

    public void add(String name, int score) {
        names.add(name);
        scores.add(score);
        minHeap.offer(names.size() - 1);
        maxHeap.offer(minHeap.poll());
    }

    public String get() {
        minHeap.offer(maxHeap.poll());
        return names.get(minHeap.peek());
    }
}
