package com.leetcode.test.code623;

import com.leetcode.test.TreeNode;

public class Me {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }
        f(root, val, 1, depth);
        return root;
    }


    public void f(TreeNode root, int val, int cur, int tar){
        if(root == null){
            return;
        }
        if(cur == tar - 1){
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = root.left;
            root.left = newLeft;
            TreeNode newRight = new TreeNode(val);
            newRight.right = root.right;
            root.right = newRight;
            return;
        }
        f(root.left, val, cur + 1, tar);
        f(root.right, val, cur + 1, tar);
    }
}
