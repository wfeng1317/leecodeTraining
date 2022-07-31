package com.leetcode.test.week304.code6134;

import java.util.Arrays;

public class Me {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if(node1 == node2){
            return node1;
        }
        if(edges[node1] == -1 && edges[node2] == -1){
            return -1;
        }
        int n = edges.length;
        if(edges[node1] == -1 || edges[node2] == -1){
            //如果一个节点不能动，那答案就是另一个节点到它的距离
            boolean[] d = new boolean[n];
            int start = node1 == -1 ? node2 : node1;
            int end = node1 == -1 ? node1 : node2;
            while(start != -1 && !d[start]){
                d[start] = true;
                if(start == end){
                    return end;
                }
                start = edges[start];
            }
            return -1;
        }
        //两个节点都可以动，记录他们到每一个节点的步数

        int[] p1 = new int[n];
        boolean[] d1 = new boolean[n];
        Arrays.fill(p1, -1);
        int s = node1;
        int path = 0;
        while(s != -1 && !d1[s]){
            p1[s] = path;
            path++;
            d1[s] = true;
            s = edges[s];

        }
        int[] p2 = new int[n];
        boolean[] d2 = new boolean[n];
        Arrays.fill(p2, -1);
        s = node2;
        path = 0;
        while(s != -1 && !d2[s]){
            p2[s] = path;
            path++;
            d2[s] = true;
            s = edges[s];
        }
        //判断每个节点二者都能到的较大的最小值
        int min = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < n; i++){
            if(p1[i] >= 0 && p2[i] >= 0){
                //二者都能到
                if(Math.max(p1[i], p2[i]) < min){
                    min = Math.max(p1[i], p2[i]);
                    res = i;
                }
            }
        }
        return res;


    }
}
