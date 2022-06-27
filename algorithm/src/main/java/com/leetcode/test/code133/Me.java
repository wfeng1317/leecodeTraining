package com.leetcode.test.code133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Me {

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node now = new Node(node.val, new ArrayList<Node>());
        Map<Integer, Node> map = new HashMap<>();
        map.put(now.val, now);
        f(node, now, map);
        return now;
    }

    //给定原始节点，将现在节点的邻居克隆好，已经遍历的节点无需重复遍历
    public void f(Node pre, Node now, Map<Integer, Node> map){
        //遍历pre的邻居，依次填充好他们的邻居
        Node newNode = null;
        for(Node n : pre.neighbors){
            if(!map.containsKey(n.val)){
                newNode = new Node(n.val, new ArrayList<Node>());
                map.put(newNode.val, newNode);
                f(n, newNode, map);
            }else{
                newNode = map.get(n.val);
            }
            now.neighbors.add(newNode);
        }
    }
}

