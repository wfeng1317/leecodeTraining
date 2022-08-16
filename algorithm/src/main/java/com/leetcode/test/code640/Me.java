package com.leetcode.test.code640;

public class Me {
    public String solveEquation(String equation) {
        String[] lr = equation.split("=");
        int[] leftInfo = f(lr[0]);
        int[] rightInfo = f(lr[1]);
        if(leftInfo[0] == rightInfo[0]){
            return leftInfo[1] == rightInfo[1] ? "Infinite solutions" : "No solution";
        }
        return "x=" + (rightInfo[1] - leftInfo[1]) / (leftInfo[0] - rightInfo[0]);

    }

    public static int[] f(String s){
        int lx = 0;//左边x的数量
        int lconst = 0;
        int pn = 1;
        StringBuilder sb = new StringBuilder();
        String yinzi = "";
        for(int i = 0; i <= s.length(); i++){
            if(i == s.length() || s.charAt(i) == '-' || s.charAt(i) == '+'){
                yinzi = sb.toString();
                if(yinzi == ""){
                    pn = 0;
                    continue;
                }
                if(yinzi.contains("x")){
                    if(yinzi.length() == 1){
                        lx = pn == 0 ? lx - 1 : lx + 1;
                    }else{
                        lx = pn == 0 ? lx - Integer.parseInt(yinzi.substring(0, yinzi.indexOf("x"))) : lx + Integer.parseInt(yinzi.substring(0, yinzi.indexOf("x")));
                    }

                }else{
                    lconst = pn == 0 ? lconst - Integer.parseInt(yinzi) : lconst + Integer.parseInt(yinzi);
                }
                if(i == s.length()){
                    break;
                }
                sb = new StringBuilder();
                pn = s.charAt(i) == '-' ? 0 : 1;
                continue;
            }
            sb.append(s.charAt(i));
        }

        return new int[]{lx, lconst};
    }
}
