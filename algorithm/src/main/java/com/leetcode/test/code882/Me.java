package com.leetcode.test.code882;

import java.util.*;

/**
 * 38超时
 */
public class Me {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        //dfs
        int sum = 0;
        //每个点到能到达点的最大节点数
        int[][] res = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = -1;
            }
        }
        //先记录每个节点能出去的边
        ArrayList<Integer>[] allEdges = new ArrayList[n];
        //记录每条边的细分节点数
        Map<String, Integer> cnts = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            if(allEdges[edges[i][0]] == null){
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(edges[i][1]);
                allEdges[edges[i][0]] = newList;
            }else{
                allEdges[edges[i][0]].add(edges[i][1]);
            }
            if(allEdges[edges[i][1]] == null){
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(edges[i][0]);
                allEdges[edges[i][1]] = newList;
            }else{
                allEdges[edges[i][1]].add(edges[i][0]);
            }
            String key = edges[i][0] + "_" + edges[i][1];
            cnts.put(key, edges[i][2]);
        }
        String edge = null;
        List<Integer> zeroEdge = allEdges[0];
        if(zeroEdge == null){
            return 1;
        }
        //找到被感染的节点总数
        Set<Integer> set = new HashSet<>();//存放节点数
        set.add(0);
        for(int i = 0; i < zeroEdge.size(); i++){
            edge = 0 + "_" + zeroEdge.get(i);
            if(cnts.get(edge) + 1 > maxMoves){
                res[0][zeroEdge.get(i)] = maxMoves;
                continue;
            }else{
                res[0][zeroEdge.get(i)] = cnts.get(edge);
                set.add(zeroEdge.get(i));
                dfs(0, zeroEdge.get(i), maxMoves - cnts.get(edge) - 1, allEdges, cnts, res, set);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j || (res[i][j] == -1 && res[j][i] == -1)){
                    continue;
                }
                if(i < j){
                    edge = i + "_" + j;
                }else{
                    edge = j + "_" + i;
                }
                if(!cnts.containsKey(edge)){
                    continue;
                }
                if(res[i][j] != -1 && res[j][i] != -1){
                    set.add(i);
                    set.add(j);
                    if(res[i][j] + res[j][i] > cnts.get(edge)){
                        sum += cnts.get(edge);
                    }else{
                        sum += res[i][j] + res[j][i];
                    }
                }else if(res[i][j] == -1){
                    set.add(j);
                    sum += res[j][i];
                }else{
                    set.add(i);
                    sum += res[i][j];
                }
                res[i][j] = -1;
                res[j][i] = -1;
            }
        }
        return sum + set.size();
    }

    public void dfs(int from, int to, int restMoves, ArrayList[] allEdges, Map<String, Integer> cnts, int[][] res, Set<Integer> set){
        if(restMoves == 0){
            return;
        }
        String edge = null;
        for(int i = 0; i < allEdges[to].size(); i++){
            if((int)allEdges[to].get(i) == from){
                continue;
            }
            if(to < (int)allEdges[to].get(i)){
                edge = to + "_" + allEdges[to].get(i);
            }else{
                edge = allEdges[to].get(i) + "_" + to;
            }
            if(cnts.get(edge) + 1 <= restMoves){
                res[to][(int)allEdges[to].get(i)] = cnts.get(edge);
                set.add((int)allEdges[to].get(i));
                dfs(to, (int)allEdges[to].get(i), restMoves - cnts.get(edge) - 1, allEdges, cnts, res, set);
            }else{
                res[to][(int)allEdges[to].get(i)] = Math.max(restMoves, res[to][(int)allEdges[to].get(i)]);
            }
        }
    }
}
