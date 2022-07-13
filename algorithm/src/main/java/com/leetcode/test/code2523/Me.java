package com.leetcode.test.code2523;

import com.leetcode.test.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Me {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode();
        Deque<Integer> temp = new LinkedList<>();
        f(root, temp);
        TreeNode pre = res;
        for(Integer i : temp){
            pre.right = new TreeNode(i);
            pre = pre.right;
        }
        return res.right;
    }

    public void f(TreeNode root, Deque<Integer> temp){
        if(root == null){
            return;
        }
        f(root.left, temp);
        temp.addLast(root.val);
        f(root.right, temp);
    }
}
