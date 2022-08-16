package com.leetcode.test.week306.code6150;

public class Me {
    String pre = "";
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        int[] res = new int[n + 1];
        boolean[] used = new boolean[10];
        f(pattern, used, n, res);
        return pre;
    }

    public void f(String pattern, boolean[] used, int start, int[] res){
        int n = pattern.length();
        if(start == n){
            for(int i = 1; i < 10; i++){
                used[i] = true;
                res[n] = i;
                f(pattern, used, start - 1, res);
                used[i] = false;
                res[n] = 0;
            }
            return;
        }
        if(start == -1){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i <= n; i++){
                sb.append(res[i]);
            }
            String cur = sb.toString();
            if(pre.equals("") || cur.compareTo(pre) < 0){
                pre = cur;
            }
            return;
        }
        if(pattern.charAt(start) == 'I'){
            for(int i = res[start + 1] - 1; i >= 1; i--){
                if(used[i]){
                    continue;
                }
                used[i] = true;
                res[start] = i;
                f(pattern, used, start - 1, res);
                used[i] = false;
                res[start] = 0;
            }
        }else{
            for(int i = res[start + 1] + 1; i <= 9; i++){
                if(used[i]){
                    continue;
                }
                used[i] = true;
                res[start] = i;
                f(pattern, used, start - 1, res);
                used[i] = false;
                res[start] = 0;
            }
        }

    }
}
