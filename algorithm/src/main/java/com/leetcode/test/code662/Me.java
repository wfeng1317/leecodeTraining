package com.leetcode.test.code662;

import com.leetcode.test.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Me {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        //存放每一层的最小值与最大值
        Map<Integer, Node> map = new HashMap<>();
        map.put(0, new Node(0, 0));
        f(root.left, 1, 0, 0, map);
        f(root.right, 1, 1, 0, map);
        //遍历map获取最大宽度
        int max = 0;
        Set<Integer> keys = map.keySet();
        for(Integer key : keys){
            max = Math.max(map.get(key).max - map.get(key).min + 1, max);
        }
        return max;
    }


    //在 level层，父节点位置是 pre，从父节点的from来的
    //from为0表示当前节点是左孩子，为1表示当前节点是右孩子
    public void f(TreeNode root, int level, int from, int pre, Map<Integer, Node> map){
        if(root == null){
            return;
        }
        if(!map.containsKey(level)){
            map.put(level, new Node(pre * 2 + 1 + from, pre * 2 + 1 + from));
            f(root.left, level + 1, 0, pre * 2 + 1 + from, map);
            f(root.right, level + 1, 1, pre * 2 + 1 + from, map);
            return;
        }
        //如果之前这一层已有节点了
        Node sameLevel = map.get(level);
        sameLevel.min = Math.min(sameLevel.min, pre * 2 + 1 + from);
        sameLevel.max = Math.max(sameLevel.max, pre * 2 + 1 + from);
        f(root.left, level + 1, 0, pre * 2 + 1 + from, map);
        f(root.right, level + 1, 1, pre * 2 + 1 + from, map);
        return;
    }


    public static class Node{
        int min = 0;
        int max = 0;
        public Node(int mi, int ma){
            min = mi;
            max = ma;
        }
    }
}
