package com.leetcode.test.code2493;

import com.leetcode.test.TreeNode;

public class Me {

    public TreeNode pruneTree(TreeNode root) {
        //后序遍历
        f(root);
        if(root != null && root.left == null && root.right == null){
            return root.val == 0 ? null : root;
        }
        return root;
    }

    public void f(TreeNode root){
        if(root == null){
            return;
        }
        //首先判断左子树是不是叶子节点
        if(root.left != null && (root.left.left != null || root.left.right != null)){
            f(root.left);
        }
        //再判断右子树是不是叶子节点
        if(root.right != null && (root.right.left != null || root.right.right != null)){
            f(root.right);
        }
        if(root.left != null && root.left.left == null && root.left.right == null && root.left.val == 0){
            root.left = null;
        }
        if(root.right != null && root.right.left == null && root.right.right == null && root.right.val == 0){
            root.right = null;
        }
    }
}
