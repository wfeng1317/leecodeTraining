package com.leetcode.test.code297;


public class Me {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int i = 0;//用于反序列化字符数组的位置
    //null节点用"#"，不同节点间用"_"分隔

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "_" + left + "_" + right;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("_");
        return process(strs);
    }

    public TreeNode process(String[] strs){
        if(strs[i].equals("#")){
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strs[i]));
        i++;
        node.left = process(strs);
        node.right = process(strs);
        return node;
    }

}
