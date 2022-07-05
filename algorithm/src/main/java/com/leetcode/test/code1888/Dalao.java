package com.leetcode.test.code1888;

public class Dalao {
    public int minFlips(String s) {
        int c1=0,c2=0;//分别记载偶数、奇数位的1的个数
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(i%2==0){c1++;}
                else{c2++;}
            }
        }
        //先判断s长度偶数的情况，而后奇数
        if(s.length()%2==0){return s.length()/2-Math.abs(c1-c2);}
        int ans=Math.min(c1-c2,c2-c1+1);
        for(int i=0;i<s.length()-1;i++){
            int c=c2;c2=c1;c1=c;
            if(s.charAt(i)=='1'){c1++;c2--;}
            ans=Math.min(ans,Math.min(c1-c2,c2-c1+1));
        }
        return ans+s.length()/2;
    }
}
