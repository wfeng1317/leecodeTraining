package com.leetcode.test.week301.code6114;

public class Me {
    public boolean canChange(String start, String target) {
        int sn = start.length();
        int tn = target.length();
        int s = 0;
        int t = 0;
        while(s < sn && t < tn){
            if(start.charAt(s) == '_'){
                s++;
                continue;
            }
            if(target.charAt(t) == '_'){
                t++;
                continue;
            }
            if(start.charAt(s) != target.charAt(t)){
                return false;
            }
            if(start.charAt(s) == 'R'){
                if(s > t){
                    return false;
                }
            }else{
                if(s < t){
                    return false;
                }
            }
            s++;
            t++;
        }
        //如果一方越界，而另一方还有字符则返回false
        while(s < sn){
            if(start.charAt(s) != '_'){
                return false;
            }
            s++;
        }
        while(t < tn){
            if(target.charAt(t) != '_'){
                return false;
            }
            t++;
        }
        return true;


    }
}
