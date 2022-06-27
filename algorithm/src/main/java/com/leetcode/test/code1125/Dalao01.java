package com.leetcode.test.code1125;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dalao01 {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int[] peo = new int[people.size()];
        int[] f = new int[1 << n];
        int[][] pre = new int[1 << n][2];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(req_skills[i], i);
        }
        for (int i = 0; i < people.size(); i++) {
            int cur = 0;
            for (int j = 0; j < people.get(i).size(); j++) {
                cur |= 1 << map.get(people.get(i).get(j));
            }
            peo[i] = cur;
        }
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < peo.length; j++) {
                if (f[i] + 1 < f[i | peo[j]]) {
                    f[i | peo[j]] = f[i] + 1;
                    pre[i | peo[j]][0] = i;
                    pre[i | peo[j]][1] = j;
                }
            }
        }

        int[] ans = new int[f[f.length - 1]];
        for (int i = 0, idx = f.length - 1; i < ans.length; i++) {
            ans[i] = pre[idx][1];
            idx = pre[idx][0];
        }

        return ans;
    }
}
