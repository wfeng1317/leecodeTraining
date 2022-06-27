package com.leetcode.test.code621;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 如果我们填「超出」了 n+1列，那么所有的 CPU 待命状态都是可以省去的。
 * 这是因为 CPU 待命状态本身只是为了规定任意两个相邻任务的执行间隔至少为 n，
 * 但如果列数超过了 n+1，那么就算没有这些待命状态，任意两个相邻任务的执行间隔肯定也会至少为 n。
 * 此时，总执行时间就是任务的总数 tasks。
 *
 */
public class Official02 {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

}
