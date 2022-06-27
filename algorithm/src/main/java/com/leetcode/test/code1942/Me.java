package com.leetcode.test.code1942;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Me {
    public int smallestChair(int[][] times, int targetFriend) {
        int N = times.length;
        //以到达时间为key，以哪个人为value建立有序表
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //建一个小根堆，用于得到每次能选择的最小座位
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        //建一个小根堆，用于存放节点的最新离开时间
        PriorityQueue<Node> pq2 = new PriorityQueue<>((e1, e2) -> (e1.leaveTime - e2.leaveTime));
        for(int i = 0; i < N; i++){
            map.put(times[i][0], i);
            pq1.offer(i);
        }
        int cur = 0;
        int res = 0;
        int person = 0;
        int minPos = 0;
        Node newNode = null;
        while(map.size() > 0){
            cur = map.firstKey();
            person = map.get(cur);
            map.remove(cur);
            //小于当前人的到达时间的离开时间的人弹出
            while(!pq2.isEmpty() && pq2.peek().leaveTime <= cur){
                newNode = pq2.poll();
                pq1.offer(newNode.pos);
            }
            //获取最小座位
            minPos = pq1.poll();
            if(person == targetFriend){
                res = minPos;
                break;
            }
            newNode = new Node(minPos, times[person][1]);
            pq2.offer(newNode);
        }
        return res;
    }

    public static class Node{
        int pos = 0;
        int leaveTime = 0;
        public Node(int p, int lt){
            pos = p;
            leaveTime = lt;
        }
    }
}
