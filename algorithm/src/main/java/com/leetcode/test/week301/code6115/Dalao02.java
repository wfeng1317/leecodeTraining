package com.leetcode.test.week301.code6115;

import java.util.ArrayList;
import java.util.List;

public class Dalao02 {

    static final int MOD = (int) 1e9 + 7, MX_K = 13, MX = (int) 1e4 + MX_K;
    static List[] ks = new List[MX];
    static int[][] c = new int[MX][MX_K + 1];

    static {
        for (int i = 1; i < MX; i++) {
            ks[i] = new ArrayList<Integer>();
            int x = i;
            for (int p = 2; p * p <= x; ++p) {
                if (x % p == 0) {
                    int k = 0;
                    for (; x % p == 0; x /= p) ++k;
                    ks[i].add(k);
                }
            }
            if (x > 1) ks[i].add(1);
        }

        c[0][0] = c[1][0] = c[1][1] = 1;
        for (int i = 2; i < MX; ++i) {
            c[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MX_K); ++j)
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
        }
    }

    public int idealArrays(int n, int maxValue) {
        long ans = 0L;
        for (int x = 1; x <= maxValue; ++x) {
            long mul = 1L;
            for (Object k : ks[x]) mul = mul * c[n + (int) k - 1][(int) k] % MOD;
            ans += mul;
        }
        return (int) (ans % MOD);
    }
}
