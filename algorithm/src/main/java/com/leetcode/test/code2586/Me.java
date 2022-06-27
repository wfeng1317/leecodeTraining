package com.leetcode.test.code2586;

import com.leetcode.test.TreeNode;

/**
 * dfs
 */
public class Me {

    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        return process(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }


    public int process(TreeNode root, int rest){
        if(root == null){
            return 0;
        }
        int res = 0;
        if(rest == root.val){
            res++;
        }
        res += process(root.left, rest - root.val) + process(root.right, rest - root.val);
        return res;
    }
}
