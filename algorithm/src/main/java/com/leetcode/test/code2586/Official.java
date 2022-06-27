package com.leetcode.test.code2586;

import com.leetcode.test.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Official {
    public int pathSum(TreeNode root, int sum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, sum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int sum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - sum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, sum);
        ret += dfs(root.right, prefix, curr, sum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

}
