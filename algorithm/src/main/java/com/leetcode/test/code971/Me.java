package com.leetcode.test.code971;

import com.leetcode.test.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 改进
 */
public class Me {
    int cur = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        f(root, voyage, res);
        if(!res.isEmpty() && res.get(0) == -1){
            res.clear();
            res.add(-1);
        }
        return res;
    }

    public void f(TreeNode root, int[] voyage, List<Integer> res){
        if(root == null){
            return;
        }
        if(root.val != voyage[cur++]){
            res.clear();
            res.add(-1);
            return;
        }
        if(cur < voyage.length && root.left != null && voyage[cur] != root.left.val){
            res.add(root.val);
            f(root.right, voyage, res);
            f(root.left, voyage, res);
        }else{
            f(root.left, voyage, res);
            f(root.right, voyage, res);
        }
    }
}
