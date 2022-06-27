package com.leetcode.test.code2562;

public class Official {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            if (find(node1, parent) != find(node2, parent)) {
                union(node1, node2, parent);
            } else {
                return edge;//题目中只含有一个环，所以找到环的时候就是最右边的边了，直接返回就可以了
            }
        }
        return new int[0];
    }

    public static int find(int i, int[] parent) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public static void union(int x, int y, int[] parent) {
        int fx = find(x, parent);
        int fy = find(y, parent);
        if (fy != fx) {
            parent[fx] = fy;
        }
    }
}
