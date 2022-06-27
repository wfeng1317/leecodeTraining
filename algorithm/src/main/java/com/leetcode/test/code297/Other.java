package com.leetcode.test.code297;

import javax.swing.tree.TreeNode;

public class Other {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int i = 0;  //反序列化时用于标记strs数组的下标
    // 树→字符串
    public String serialize(TreeNode root) {
        if(root == null) return "null,";    // 终结条件
        String s = "";
        s += root.val + ",";    // 在字符串尾部拼接当前节点的值
        s += serialize(root.left);  // 先拼接左子节点的值
        s += serialize(root.right); // 再拼接右子节点的值
        return s;
    }

    // 字符串→树
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");    // 根据“，”分割
        return deserialize2(strs);
    }
    public TreeNode deserialize2(String[] strs) {
        if (strs[i].equals("null")) {    // 终结条件，当前节点为空
            i++;    // 当前节点为空，i也需要+1，因为字符串中空节点也占一个位置
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strs[i]));
        i++;
        node.left = deserialize2(strs);
        node.right = deserialize2(strs);
        return node;
    }
}
