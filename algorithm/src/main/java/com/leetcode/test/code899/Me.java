package com.leetcode.test.code899;

/**
 * k == 1，每一次转法
 * k > 1，总有序
 */
public class Me {

    public String orderlyQueue(String s, int k) {
        int n = s.length();
        if(k == 1){
            String min = s;
            String oldStr = s;
            int i = 0;
            while(i < n){
                //移动首字符
                String newStr = oldStr.substring(1, n) + oldStr.substring(0, 1);
                if(newStr.compareTo(min) < 0){
                    min = new String(newStr);
                }
                oldStr = newStr;
                i++;
            }
            return min;
        }else{
            //每种字符的个数
            int[] charCount = new int[26];
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                charCount[s.charAt(i) - 'a']++;
            }
            for(int i = 0; i < 26; i++){
                f(sb, i, charCount[i]);
            }
            return sb.toString();
        }
    }

    public void f(StringBuilder sb, int s, int num){
        char tar = (char)('a' + s);
        while(num > 0){
            sb.append(tar);
            num--;
        }
    }
}
