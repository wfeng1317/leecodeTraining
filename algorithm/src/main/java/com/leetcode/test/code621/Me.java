package com.leetcode.test.code621;

import java.util.Arrays;

/**
 * 若能放置的列数大于n+1，也就是最多的任务种类大于n+1时，则可以往两边放或者怎么放，可以使得待命状态消失，也就是最短时间变成任务的个数
 */
public class Me {

    public int leastInterval(char[] tasks, int n) {
        if(n == 0){
            return tasks.length;
        }
        //先记录每种任务的数量
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }
        Arrays.sort(count);
        //记录最多任务数的任务个数
        int maxCount = 1;
        int cur = 24;
        while(cur >= 0 && count[cur] == count[25]){
            maxCount++;
            cur--;
        }
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + maxCount);
    }
}
