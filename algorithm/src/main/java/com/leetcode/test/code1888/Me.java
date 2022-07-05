package com.leetcode.test.code1888;

/**
 * 参考
 */
public class Me {
    public int minFlips(String s) {
        int n = s.length();
        String target = "10";
        int count = 0;//以"10"为模板所需更改的次数
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != target.charAt(i % 2)){
                count++;
            }
        }
        //n - count 就是以"01"为模板的更改次数
        int res = Math.min(count, n - count);
        if((n & 1) == 0){//偶数直接得结果
            return res;
        }
        s += s;
        //若为奇数，改变模式为"10"，得出结果
        for(int i = 0; i < n; i++){//将i位置的字符移到结尾处
            if(s.charAt(i) != target.charAt(i % 2)){//可进行操作1，count--
                count--;
            }
            if(s.charAt(i + n) != target.charAt((i + n) % 2)){
                count++;
            }
            res = Math.min(res, Math.min(count, n - count));
        }
        return res;

    }
}
