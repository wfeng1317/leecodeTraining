package com.leetcode.test.code9;

public class Me {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
                continue;
            }
            return false;
        }
        return true;

    }
}
