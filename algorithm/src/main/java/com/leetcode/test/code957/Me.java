package com.leetcode.test.code957;

public class Me {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[] res = new int[8];
        //第一天，两边均被空置
        for(int i = 1; i < 7; i++){
            if(cells[i - 1] == cells[i + 1]){
                res[i] = 1;
            }
        }
        //从第二天往后，15一轮回
        int k = ((n - 1) % 14) + 1;
        int[] cur = new int[8];
        while(k > 1){
            for(int i = 1; i < 7; i++){
                if(res[i - 1] == res[i + 1]){
                    cur[i] = 1;
                }else{
                    cur[i] = 0;
                }
            }
            k--;
            int[] temp = res;
            res = cur;
            cur = temp;
        }
        return res;
    }
}
