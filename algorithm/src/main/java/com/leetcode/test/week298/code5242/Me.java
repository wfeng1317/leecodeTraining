package com.leetcode.test.week298.code5242;

public class Me {

    public String greatestLetter(String s) {
        int[] status = new int[26];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                if(status[s.charAt(i) - 'a'] == 0 || status[s.charAt(i) - 'a'] == 2){
                    status[s.charAt(i) - 'a']++;
                }
            }
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                if(status[s.charAt(i) - 'A'] == 0 || status[s.charAt(i) - 'A'] == 1){
                    status[s.charAt(i) - 'A'] += 2;
                }
            }
        }
        for(int i = 25; i >= 0; i--){
            if(status[i] == 3){
                return String.valueOf((char)('A' + i));
            }
        }
        return "";

    }
}
