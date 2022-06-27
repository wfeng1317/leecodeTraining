package com.leetcode.test.code2303;

public class Me {

    public double calculateTax(int[][] brackets, int income) {
        double res = 0.0;
        int n = brackets.length;
        if(brackets[0][0] >= income){
            res += income * brackets[0][1];
            return res * 0.01;
        }else{
            res += brackets[0][0] * brackets[0][1];
        }
        for(int i = 1; i < n; i++){
            if(brackets[i][0] >= income){
                res += (income - brackets[i - 1][0]) * brackets[i][1];
                break;
            }else{
                res += (brackets[i][0] - brackets[i - 1][0]) * brackets[i][1];
            }
        }
        return res * 0.01;

    }
}
