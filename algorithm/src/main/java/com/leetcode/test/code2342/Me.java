package com.leetcode.test.code2342;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Me {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int cur = 0;
        for(int i = 0; i < n; i++){
            //获取当前数的数位和
            cur = f(nums[i]);
            if(!map.containsKey(cur)){
                map.put(cur, new PriorityQueue<Integer>((e1, e2) -> e2 - e1));
            }
            map.get(cur).add(nums[i]);
        }
        PriorityQueue<Integer> mm;
        for(Integer key : map.keySet()){
            mm = map.get(key);
            if(mm.size() < 2){
                continue;
            }
            res = Math.max(mm.poll() + mm.poll(), res);
        }
        return res == 0 ? -1 : res;
    }

    public int f(int k){
        int res = 0;
        while(k > 0){
            res += (k % 10);
            k /= 10;
        }
        return res;
    }
}
