package com.leetcode.test.code2038;

public class Me {
    /**
     删除节点并不会使的选择更多
     */
    public boolean winnerOfGame(String colors) {
        if(colors.length() <= 2){
            return false;
        }
        char[] strs = colors.toCharArray();
        int minus = 0;
        for(int i = 1; i < strs.length - 1; i++){
            if(strs[i] == strs[i - 1] && strs[i] == strs[i + 1]){
                minus = strs[i] == 'A' ? minus + 1 : minus - 1;
            }
        }
        return minus > 0;
    }
}
