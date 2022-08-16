package com.leetcode.test.code491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Me {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        Set<String> tempRes = new HashSet<>();
        for(int i = n - 1; i >= 0; i--){
            f(tempRes, nums[i]);
        }
        return tempRes.stream().map(item -> {
            List<Integer> r = new ArrayList<>();
            for(String s : item.split("_")){
                r.add(Integer.parseInt(s));
            }
            return r;
        }).filter(item -> item.size() > 1).collect(Collectors.toList());
    }

    public void f(Set<String> tempRes, int cur){
        List<String> res1 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        //首先把自己加进去
        sb.append(cur);
        res1.add(sb.toString());
        for(String pre : tempRes){
            int firstNum = Integer.parseInt(pre.split("_")[0]);
            if(cur <= firstNum){
                sb = new StringBuilder();
                sb.append(cur + "_");
                sb.append(pre);
                res1.add(sb.toString());
            }
        }
        tempRes.addAll(res1);
    }
}
