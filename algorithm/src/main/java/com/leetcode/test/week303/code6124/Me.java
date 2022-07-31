package com.leetcode.test.week303.code6124;

public class Me {
    public char repeatedCharacter(String s) {
        int[] fre = new int[26];
        for(int i = 0; i < s.length(); i++){
            fre[s.charAt(i) - 'a']++;
            if(fre[s.charAt(i) - 'a'] == 2){
                return s.charAt(i);
            }
        }
        return ' ';

    }
}
