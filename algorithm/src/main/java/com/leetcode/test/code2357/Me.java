package com.leetcode.test.code2357;

public class Me {
    public int orchestraLayout(int num, int xPos, int yPos) {
        //找到(xPos, yPos)在第几圈
        int loop = Math.min(xPos, Math.min(yPos, Math.min(num - 1 - yPos, num - 1- xPos))) + 1;
        //当前圈的边长
        long cur = num - 2 * (loop - 1);
        //当前圈前面有几个值
        long area = (long) num * (long) num - cur * cur;
        //当前圈左上角的值
        long start = (area % 9) + 1;
        int res = 0;
        if(xPos == loop - 1){//up
            res = (int)((start + (yPos - (loop - 1))) % 9);
        }else if(yPos - (loop - 1) + 1== cur){//right
            res = (int)((start + (cur - 1) + xPos - (loop - 1)) % 9);
        }else if(xPos - (loop - 1) + 1 == cur){//down
            res = (int)((start + 2 * (cur - 1) + loop - 1 + cur - 1 - yPos) % 9);
        }else{
            //left
            res = (int)((start + 3 * (cur - 1) + loop - 1 + cur - 1 - xPos) % 9);
        }
        return (res % 9) == 0 ? 9 : (res % 9);
    }
}
