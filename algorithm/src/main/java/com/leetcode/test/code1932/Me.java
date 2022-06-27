package com.leetcode.test.code1932;

import com.leetcode.test.TreeNode;

import java.util.*;

public class Me {

    //不能有相同值的节点
    public TreeNode canMerge(List<TreeNode> trees) {
        int n = trees.size();
        TreeNode cur = null;
        //准备一张哈希表，用于表示每个根节点的值对应的树
        Map<Integer, TreeNode> roots = new HashMap<>();//根值->根
        Map<Integer, TreeNode> leaves = new HashMap<>();//叶值->叶
        Map<TreeNode, TreeNode> parents = new HashMap<>();//叶->叶父
        Map<TreeNode, TreeNode> nr = new HashMap<>();//节点->根
        for(int i = 0; i < n; i++){
            cur = trees.get(i);
            nr.put(cur, cur);
            roots.put(cur.val, cur);
            if(cur.left != null){
                leaves.put(cur.left.val, cur.left);
                parents.put(cur.left, cur);
                nr.put(cur.left, cur);
            }
            if(cur.right != null){
                leaves.put(cur.right.val, cur.right);
                parents.put(cur.right, cur);
                nr.put(cur.left, cur);
            }
        }
        if(roots.size() != trees.size()){
            return null;
        }

        TreeNode curLeaf = null;
        TreeNode curParent = null;
        for(int i = 0; i < n; i++){
            cur = trees.get(i);
            if(!roots.containsKey(cur.val)){
                continue;
            }
            if(leaves.containsKey(cur.val)){
                curLeaf = leaves.get(cur.val);
                curParent = parents.get(curLeaf);
                if(cur == curLeaf || nr.get(cur) == nr.get(curParent)){
                    continue;
                }
                if(curLeaf.val < curParent.val){
                    curParent.left = cur;
                }else{
                    curParent.right = cur;
                }
                parents.put(cur, curParent);
                nr.put(cur, nr.get(curParent));
                if(cur.left != null){
                    nr.put(cur.left, nr.get(cur));
                }
                if(cur.right != null){
                    nr.put(cur.right, nr.get(cur));
                }
                leaves.remove(curLeaf.val);
                roots.remove(cur.val);
            }
        }
        Set<Integer> set = roots.keySet();
        if(set.size() > 1){
            return null;
        }
        for(Integer key : set){
            cur = roots.get(key);
        }
        //中序遍历，判断是否有序
        List<Integer> nodes = new ArrayList<>();
        process(cur, nodes);
        for(int i = 1; i < nodes.size(); i++){
            if(nodes.get(i) <= nodes.get(i - 1)){
                return null;
            }
        }
        return cur;
    }
    public void process(TreeNode root, List<Integer> nodes){
        if(root == null){
            return;
        }
        process(root.left, nodes);
        nodes.add(root.val);
        process(root.right, nodes);
        return;
    }
}
