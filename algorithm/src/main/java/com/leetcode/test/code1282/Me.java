package com.leetcode.test.code1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Me {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> temp = null;
        for(int i = 0; i < n; i++){
            if(!map.containsKey(groupSizes[i])){
                map.put(groupSizes[i], new ArrayList<Integer>(groupSizes[i]));
            }
            temp = map.get(groupSizes[i]);
            temp.add(i);
            if(temp.size() == groupSizes[i]){
                res.add(new ArrayList<Integer>(temp));
                temp.clear();
            }
        }
        return res;
    }
}
