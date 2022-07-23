package com.leetcode.test.code2527;

import com.leetcode.test.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Me {
    int sum = 0;
    int target = 0;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        Set<TreeNode> set = new HashSet<>();
        f(root, targetSum, set);
        return sum;
    }

    //给定targetSum
    public void f(TreeNode root, int rest, Set<TreeNode> set){
        if(root == null){
            return;
        }
        if(rest - root.val == 0){
            sum++;
        }
        if(!set.contains(root.left)){
            set.add(root.left);
            f(root.left, target, set);
        }
        if(!set.contains(root.right)){
            set.add(root.right);
            f(root.right, target, set);
        }
        f(root.left, rest - root.val, set);
        f(root.right, rest - root.val, set);

    }
}
