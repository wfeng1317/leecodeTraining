package com.leetcode.test.code972;

import java.util.HashSet;
import java.util.Set;

public class Me {

    public boolean isRationalEqual(String s, String t) {
        int slkuo = s.indexOf("(");
        int srkuo = s.indexOf(")");
        int tlkuo = t.indexOf("(");
        int trkuo = t.indexOf(")");

        if(slkuo != -1 && srkuo != -1 && tlkuo != -1 && trkuo != -1){
            //二者都是循环小数
            int sp = s.indexOf(".");
            int tp = t.indexOf(".");
            //特殊情况特殊判断，循环体全为0或全为9
            double ds = f(s);
            double dt = f(t);
            if(ds != -1 && dt != -1){
                return ds == dt;
            }else if ((ds == -1 && dt != -1) || (dt == -1 && ds != -1)){
                return false;
            }
            //先判断整数部分是否相等
            if(!s.substring(0, sp).equals(t.substring(0, tp))){
                //整数部分不相等直接返回false
                return false;
            }

            int ss = sp + 1 == slkuo ? sp + 2 : sp + 1;
            int ts = tp + 1 == tlkuo ? tp + 2 : tp + 1;
            Set<String> set = new HashSet<>();
            String cur = new StringBuilder().append(ss).append("_").append(ts).toString();
            while(!set.contains(cur)){
                set.add(cur);
                if(s.charAt(ss) == t.charAt(ts)){
                    ss = s.charAt(ss + 1) == ')' ? slkuo + 1 : (ss + 1 == slkuo ? slkuo + 1 : ss + 1);
                    ts = t.charAt(ts + 1) == ')' ? tlkuo + 1 : (ts + 1 == tlkuo ? tlkuo + 1 : ts + 1);
                    cur = new StringBuilder().append(ss).append("_").append(ts).toString();
                }else{
                    return false;
                }
            }
            return true;
        }
        //二者并不全有括号
        if(slkuo == -1 && srkuo == -1 && tlkuo == -1 && trkuo == -1){
            //都没括号
            return Double.parseDouble(s) == Double.parseDouble(t);
        }
        double real = 0.0;
        if(slkuo != -1 && srkuo != -1){
            //s有，t没有
            real = f(s);
            return real != -1 && real == Double.parseDouble(t);
        }
        //t有，s没有
        real = f(t);
        return real != -1 && real == Double.parseDouble(s);

    }


    public double f(String s){
        int sp = s.indexOf(".");
        int slkuo = s.indexOf("(");
        int srkuo = s.indexOf(")");
        if(Integer.parseInt(s.substring(slkuo + 1, srkuo)) == 0){
            //括号内全是0
            return Double.parseDouble(s.substring(0, slkuo));

        }
        int i = slkuo + 1;
        for(; i < srkuo; i++){
            if(s.charAt(i) != '9'){
                return -1;
            }
        }
        i = slkuo - 1;
        while(i > sp){
            if(s.charAt(i) != '9'){
                break;
            }
            i--;
        }

        if(i == sp){
            //小数点后全是9
            return Double.parseDouble(s.substring(0, sp)) + 1.0;
        }
        return Double.parseDouble(new StringBuilder().append(s.substring(0, i)).append((char)(s.charAt(i) + 1)).toString());
    }
}
