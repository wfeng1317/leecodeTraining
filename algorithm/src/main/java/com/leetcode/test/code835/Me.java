package com.leetcode.test.code835;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Me {

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int count = n * n;
        //找到img1中的1与img2中的1相距一样的最大个数
        Map<String, Integer> map = new HashMap<>();
        for(int i1 = 0; i1 < n; i1++){
            for(int i2 = 0; i2 < n; i2++){
                if(img1[i1][i2] == 0){
                    continue;
                }
                for(int j1 = 0; j1 < n; j1++){
                    for(int j2 = 0; j2 < n; j2++){
                        if(img2[j1][j2] == 0){
                            continue;
                        }
                        String key = (i1 - j1) + "_" + (i2 - j2);
                        map.put(key, map.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }
        int res = 0;
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            res = Math.max(res, map.get(key));
        }
        return res;
    }
}
