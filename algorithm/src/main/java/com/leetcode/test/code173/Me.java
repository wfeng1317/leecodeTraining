package com.leetcode.test.code173;

import com.leetcode.test.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Me {

    List<Integer> vals = new ArrayList<>();
    int index = 0;

    public Me(TreeNode root) {
        processRecursion(root, vals);
        processMorris(root, vals);
    }

    public int next() {
        return vals.get(index++);
    }

    public boolean hasNext() {
        return index < vals.size();
    }


    //递归
    public void processRecursion(TreeNode root, List<Integer> vals){
        if(root == null){
            return;
        }
        processRecursion(root.left, vals);
        vals.add(root.val);
        processRecursion(root.right, vals);
        return;
    }


    //morris遍历
    public void processMorris(TreeNode root, List<Integer> vals){
        if(root == null){
            return;
        }
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){//若当前左子树不为空，则找到左子树最右的位置
                TreeNode mostRight = cur.left;
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                mostRight.right = null;
            }
            vals.add(cur.val);
            cur = cur.right;
        }
    }
}
