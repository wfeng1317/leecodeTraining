package com.leetcode.test.code165;

/**
 * "." 作正则时要使用"\\." 当使用String.split()时要注意
 */
public class Me {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        int n1 = v1.length;
        String[] v2 = version2.split("\\.");
        int n2 = v2.length;
        int i = 0;
        while(i < n1 && i < n2){
            if(Integer.parseInt(v1[i]) != Integer.parseInt(v2[i])){
                return Integer.parseInt(v1[i]) > Integer.parseInt(v2[i]) ? 1 : -1;
            }
            i++;
        }
        if(i == n1 && i == n2){
            return 0;
        }
        if(i == n1){
            return f(v2, i) ? 0 : -1;
        }
        return f(v1, i) ? 0 : 1;
    }

    public static boolean f(String[] v, int start){
        int n = v.length;
        while(start < n){
            if(Integer.parseInt(v[start]) != 0){
                return false;
            }
            start++;
        }
        return true;
    }
}
