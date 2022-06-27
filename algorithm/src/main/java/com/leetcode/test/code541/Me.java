package com.leetcode.test.code541;

public class Me {

    public String reverseStr(String s, int k) {
        int i = 0;
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        while(i < n){
            int rest = n - i;
            if(rest <= k){
                add(sb, s.substring(i), true);
                break;
            }else if(rest >= 2 * k){
                add(sb, s.substring(i, i + k), true);
                add(sb, s.substring(i + k, i + 2 * k), false);
                i += 2 * k;
            }else{
                add(sb, s.substring(i, i + k), true);
                add(sb, s.substring(i + k), false);
                break;
            }
        }
        return sb.toString();
    }

    public void add(StringBuffer sb, String s1, boolean b){
        if(b){
            for(int i = s1.length() - 1; i >= 0; i--){
                sb.append(s1.charAt(i));
            }
            return;
        }
        sb.append(s1);
    }
}
