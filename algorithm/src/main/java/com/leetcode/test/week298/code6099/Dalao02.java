package com.leetcode.test.week298.code6099;

public class Dalao02 {

    public int longestSubsequence(String s, int k) {
        int n = s.length();
        String kstr = Integer.toBinaryString(k);
        int m = kstr.length();
        // s长度小于k二进制长度，s十进制一定小于k，返回s.length()
        if (n < m) {
            return n;
        }
        int ans = 0;
        int i = 0;
        // 从s的低位开始取长度为m的滑窗，和k进行比较
        for (i = n - m; i >= 0; i--) {
            // 如果s中长度为m的子序列不大于k，就表示找到了一个解，长度至少为m
            if (compare(s.substring(i, i + m), kstr)) {
                ans = m;
                break;
            }
        }
        // 没有找到合法的解，但是长度m-1的序列一定小于k
        if (ans == 0) {
            return m - 1;
        }
        // 加上前面的0充当前导0
        for (int j = i - 1; j >= 0; j--) {
            if (s.charAt(j) == '0') {
                ans++;
            }
        }
        return ans;
    }

    // 从高位依次比较s和t，如果s不大于t，那么返回true，反之返回false
    private boolean compare(String s, String t) {
        int m = s.length();
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) > t.charAt(i)) {
                return false;
            } else if (s.charAt(i) < t.charAt(i)){
                return true;
            }
        }
        return true;
    }
}
