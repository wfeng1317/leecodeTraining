package com.leetcode.test.code2288;

public class Me {

    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        int n = words.length;
        for(int i = 0; i < n; i++){
            if(words[i].charAt(0) != '$' || !f(words[i])){
                continue;
            }
            words[i] = "$" + String.format("%.2f", Long.parseLong(words[i].substring(1)) * (100 - discount) * 0.01);
        }
        String res = "";
        for(int i = 0; i < n - 1; i++){
            res += words[i] + " ";
        }
        return res + words[n - 1];
    }

    public boolean f(String s){
        if(s.length() == 1){
            return false;
        }
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
