package com.leetcode.test.code2102;

import java.util.HashMap;
import java.util.TreeSet;

public class Me {
    TreeSet<Node> oldSet;
    HashMap<String, Node> oldMap;
    TreeSet<Node> newSet;
    HashMap<String, Node> newMap;

    public Me() {
        oldSet = new TreeSet<Node>((e1, e2) -> {
            return e1.score == e2.score ? e1.name.compareTo(e2.name) : e2.score - e1.score;
        });
        newSet = new TreeSet<Node>((e1, e2) -> {
            return e1.score == e2.score ? e1.name.compareTo(e2.name) : e2.score - e1.score;
        });
        oldMap = new HashMap<>();
        newMap = new HashMap<>();
    }

    public void add(String name, int score) {
        Node cur = null;
        if(oldMap.containsKey(name)){
            //插入景点已被移除过
            cur = oldMap.get(name);
            if(cur.score == score){
                return;
            }
            Node newNode = new Node(name, score);
            if(cur.score < score){
                if(score < newSet.first().score || (score == newSet.first().score && name.compareTo(newSet.first().name) > 0)){
                    //要把候选的最小景点挤下来
                    Node less = newSet.pollFirst();
                    oldSet.remove(cur);
                    oldMap.remove(name);
                    oldMap.put(less.name, less);
                    oldSet.add(less);

                    newSet.add(newNode);
                    newMap.remove(less.name);
                    newMap.put(name, newNode);
                    return;
                }
            }
            oldSet.remove(cur);
            oldMap.put(name, newNode);
            oldSet.add(newNode);
            return;
        }else if(newMap.containsKey(name)){
            //插入景点在候选名单
            cur = newMap.get(name);
            if(cur.score == score){
                return;
            }
            Node newNode = new Node(name, score);
            if(cur.score > score){
                if(score > oldSet.last().score || (score == oldSet.last().score && oldSet.last().name.compareTo(name) > 0)){
                    //要把移除的最大景点抬上来
                    Node higher = oldSet.pollLast();
                    oldSet.add(newNode);
                    oldMap.remove(higher.name);
                    oldMap.put(name, newNode);

                    newSet.remove(cur);
                    newSet.add(higher);
                    newMap.remove(name);
                    newMap.put(higher.name, higher);
                    return;
                }
            }
            newSet.remove(cur);
            newMap.put(name, newNode);
            newSet.add(newNode);
            return;
        }else{
            //完全新景点
            Node newNode = new Node(name, score);
            if(oldSet.size() > 0 && (score > oldSet.last().score || (score == oldSet.last().score && oldSet.last().name.compareTo(name) > 0))){
                //将移除的最大景点抬上来
                Node higher = oldSet.pollLast();
                oldSet.add(newNode);
                oldMap.remove(higher.name);
                oldMap.put(name, newNode);

                newSet.add(higher);
                newMap.put(higher.name, higher);
            }else{
                //放到候选者中
                newSet.add(newNode);
                newMap.put(name, newNode);
            }
        }
    }

    public String get() {
        Node res = newSet.pollFirst();
        oldSet.add(res);
        oldMap.put(res.name, res);
        newMap.remove(res.name);
        return res.name;

    }

    public static class Node{
        public String name;
        public int score;
        public Node(String n, int s){
            name = n;
            score = s;
        }
    }
}
