package com.leetcode.test.code20;

public class Me {
    public boolean isValid(String s) {
        int n = s.length();
        char[] stack = new char[n];
        int size = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack[size] = s.charAt(i);
                size++;
                continue;
            }
            if(size == 0){
                return false;
            }
            if((s.charAt(i) == ')' && stack[size - 1] == '(') || (s.charAt(i) == ']' && stack[size - 1] == '[') || (s.charAt(i) == '}' && stack[size - 1] == '{')){
                size--;
            }else{
                return false;
            }
        }
        return size == 0;
    }
}
