package com.leetcode.test.code636;

import java.util.List;

public class Me {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        String[] stack = new String[250];
        int[] reduce = new int[n];
        int size = 0;
        int funcId = 0;
        int time = 0;
        int curTime = 0;
        int preId = -1;
        for(String log : logs){
            String[] logStrs = log.split(":");
            funcId = Integer.parseInt(logStrs[0]);
            time = Integer.parseInt(logStrs[2]);
            if("start".equals(logStrs[1])){
                stack[size] = log;
                size++;
            }else{
                size--;
                if(size == 0){
                    preId = -1;
                }else{
                    preId = Integer.parseInt(stack[size - 1].split(":")[0]);
                }
                //只要前一个不是同一个函数，就要进行时间的叠加
                curTime = time - Integer.parseInt(stack[size].split(":")[2]) + 1;
                if(preId != funcId){
                    res[funcId] += curTime;
                    if(preId != -1){
                        reduce[preId] += curTime;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            res[i] -= reduce[i];
        }
        return res;
    }
}
