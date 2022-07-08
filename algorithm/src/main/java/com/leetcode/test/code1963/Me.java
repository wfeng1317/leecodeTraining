package com.leetcode.test.code1963;

public class Me {
    public int minSwaps(String s) {
        int n = s.length();
        int res = 0;
        int zuo = 0;
        int you = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '['){
                zuo++;
            }else{
                you++;
            }
            if(you > zuo){
                //将这个you的位置与最右的左交换
                you--;
                zuo++;
                res++;
            }
        }
        return res;
    }
}
