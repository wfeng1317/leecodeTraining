package com.leetcode.test.code2171;

import java.util.Arrays;

public class Me {

    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long[] prefix = new long[n];
        prefix[0] = beans[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] + beans[i];
        }
        long res = Long.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--){
            //保留到i位置，一共需要拿掉几颗豆
            long cur = prefix[n - 1] - prefix[i] - (long)beans[i] * (long)(n - i - 1);
            cur = i != 0 ? cur + prefix[i - 1] : cur;
            res = Math.min(res, cur);
        }
        return res;
    }
}
