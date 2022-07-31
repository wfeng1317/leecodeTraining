package com.leetcode.test.code1161;

import com.leetcode.test.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Me {
    public int maxLevelSum(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        levelSum.add(0);
        f(root, 1, levelSum);
        int max = Integer.MIN_VALUE;
        int res = 1;
        for(int i = 1; i < levelSum.size(); i++){
            if(levelSum.get(i) > max){
                res = i;
                max = levelSum.get(i);
            }
        }
        return res;
    }

    public void f(TreeNode root, int curLevel, List<Integer> levelSum){
        if(root == null){
            return;
        }
        if(levelSum.size() <= curLevel){
            levelSum.add(root.val);
        }else{
            levelSum.set(curLevel, levelSum.get(curLevel) + root.val);
        }
        f(root.left, curLevel + 1, levelSum);
        f(root.right, curLevel + 1, levelSum);
    }
}
