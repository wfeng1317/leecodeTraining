package com.leetcode.test.code2201;

import java.util.HashMap;
import java.util.Map;

public class Me {

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int res = 0;
        int num = artifacts.length;
        //每个工件对应的格子数
        int[] gridNum = new int[num];
        //每一个方块对应一个工件
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < num; i++){
            //封装当前工件的信息
            for(int row = artifacts[i][0]; row <= artifacts[i][2]; row++){
                for(int col = artifacts[i][1]; col <= artifacts[i][3]; col++){
                    map.put(row * n + col, i);
                }
            }
            gridNum[i] = (artifacts[i][2] - artifacts[i][0] + 1) * (artifacts[i][3] - artifacts[i][1] + 1);
        }
        //遍历每一次dig，若暴露后工件格子数为0，则表示可提取
        int digPos = 0;
        for(int i = 0; i < dig.length; i++){
            digPos = dig[i][0] * n + dig[i][1];
            if(!map.containsKey(digPos)){
                continue;
            }
            if(--gridNum[map.get(digPos)] == 0){
                res++;
            }
        }
        return res;
    }
}
