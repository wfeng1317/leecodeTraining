package com.leetcode.test.code2453;

import com.leetcode.test.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Me {
    public int[] levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        f(root, list, 0);
        for(List<Integer> level : list){
            res.addAll(level);
        }
        int[] resArr = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public void f(TreeNode root, List<List<Integer>> list, int cur){
        if(root == null){
            return;
        }
        if(list.size() <= cur){
            list.add(new ArrayList<Integer>());
        }
        list.get(cur).add(root.val);
        f(root.left, list, cur + 1);
        f(root.right, list, cur + 1);
    }
}
