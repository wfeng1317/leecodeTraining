package com.leetcode.test.code1932;

import com.leetcode.test.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Official {

    // 存储所有叶节点值的哈希集合
    HashSet<Integer> leaves = new HashSet<>();
    // 存储 (根节点值, 树) 键值对的哈希映射
    HashMap<Integer, TreeNode> candidates = new HashMap<>();
    // 在中序遍历中存储中序遍历上一个遍历到的值，便于检查严格单调性
    int prev = 0;

    public TreeNode canMerge(List<TreeNode> trees) {
        for (TreeNode tree : trees) {
            if (tree.left != null) {
                leaves.add(tree.left.val);
            }
            if (tree.right != null) {
                leaves.add(tree.right.val);
            }
            candidates.put(tree.val, tree);
        }
        for (TreeNode tree : trees) {
            // 寻找合并完成后的树的根节点
            if (!leaves.contains(tree.val)) {
                // 将其从哈希映射中移除
                candidates.remove(tree.val);
                // 从根节点开始进行遍历
                // 如果中序遍历有严格单调性，并且所有树的根节点都被遍历到，说明可以构造二叉搜索树
                prev = 0;
                return (dfs(tree) && candidates.isEmpty()) ? tree : null;
            }
        }
        return null;
    }

    // 中序遍历，返回值表示是否有严格单调性
    private boolean dfs(TreeNode tree) {
        if (tree == null) {
            return true;
        }
        // 如果遍历到叶节点，并且存在可以合并的树，那么就进行合并
        if (tree.left == null && tree.right == null && candidates.containsKey(tree.val)) {
            tree.left = candidates.get(tree.val).left;
            tree.right = candidates.get(tree.val).right;
            // 合并完成后，将树从哈希映射中移除，以便于在遍历结束后判断是否所有树都被遍历过
            candidates.remove(tree.val);
        }

        // 先遍历左子树
        if (!dfs(tree.left)) {
            return false;
        }
        // 再遍历当前节点
        if (tree.val <= prev) {
            return false;
        }
        prev = tree.val;
        // 最后遍历右子树
        return dfs(tree.right);
    }
}
