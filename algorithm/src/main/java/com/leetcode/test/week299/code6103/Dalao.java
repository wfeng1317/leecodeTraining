package com.leetcode.test.week299.code6103;

import java.util.ArrayList;
import java.util.List;

public class Dalao {

    List<Integer>[] g;
    int[] nums, xor, in, out;
    int clock;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        this.nums = nums;
        xor = new int[n];
        in = new int[n];
        out = new int[n];
        dfs(0, -1);

        for (int[] e : edges)
            if (!isParent(e[0], e[1])) {
                int tmp = e[0];
                e[0] = e[1];
                e[1] = tmp;
            }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; ++i) {
            int x1 = edges[i][0], y1 = edges[i][1];
            for (int j = 0; j < i; ++j) {
                int x2 = edges[j][0], y2 = edges[j][1];
                int x, y, z;
                if (isParent(y1, x2)) { // y1 是 x2 的父节点（或重合）
                    x = xor[y2];
                    y = xor[y1] ^ xor[y2];
                    z = xor[0] ^ xor[y1];
                } else if (isParent(y2, x1)) { // y2 是 x1 的父节点（或重合）
                    x = xor[y1];
                    y = xor[y2] ^ xor[y1];
                    z = xor[0] ^ xor[y2];
                } else { // 删除的两条边分别属于两颗不相交的子树
                    x = xor[y1];
                    y = xor[y2];
                    z = xor[0] ^ xor[y1] ^ xor[y2];
                }
                ans = Math.min(ans, Math.max(Math.max(x, y), z) - Math.min(Math.min(x, y), z));
            }
        }
        return ans;
    }

    void dfs(int x, int fa) {
        in[x] = ++clock;
        xor[x] = nums[x];
        for (Integer y : g[x])
            if (y != fa) {
                dfs(y, x);
                xor[x] ^= xor[y];
            }
        out[x] = clock;
    }
    boolean isParent(int x, int y) {
        return in[x] <= in[y] && in[y] <= out[x];
    }
}
