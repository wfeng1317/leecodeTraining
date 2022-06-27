package com.leetcode.test.code2606;

public class Me {

    /**
     * 考虑到数值溢出的情况，故将a和b均转化成long
     * long型数据右移63位后需转成int，并且若为负数，右移后为-1，正数则为0
     * @param a
     * @param b
     * @return
     */
    public int maximum(int a, int b) {
        long c = a;
        long d = b;
        int x = 1 + (int)((c - d) >> 63);
        return x * a + (x ^ 1) * b;
    }
}
