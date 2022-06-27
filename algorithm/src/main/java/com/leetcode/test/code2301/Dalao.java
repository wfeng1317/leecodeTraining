package com.leetcode.test.code2301;

import java.util.HashMap;

public class Dalao {

    public long distinctNames(String[] ideas) {
        HashMap<String, Integer> group = new HashMap<>();
        for (String s : ideas) {
            String t = s.substring(1);
            group.put(t, group.getOrDefault(t, 0) | 1 << (s.charAt(0) - 'a'));
        }
        long ans = 0L;
        int[][] cnt = new int[26][26];
        for (Integer mask : group.values())
            for (int i = 0; i < 26; i++)
                if ((mask >> i & 1) == 0) {
                    for (int j = 0; j < 26; j++)
                        if ((mask >> j & 1) > 0) ++cnt[i][j];
                } else {
                    for (int j = 0; j < 26; j++)
                        if ((mask >> j & 1) == 0) ans += cnt[i][j];
                }
        return ans * 2;
    }
}
