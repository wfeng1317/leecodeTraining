package com.leetcode.test.code1154;

public class Me {
    public int dayOfYear(String date) {
        String[] ymd = date.split("-");
        int year = Integer.parseInt(ymd[0]);
        int[] m = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] preMd = new int[13];
        for(int i = 1; i <= 12; i++){
            preMd[i] = preMd[i - 1] + m[i - 1];
        }
        int month = Integer.parseInt(ymd[1]);
        int day = Integer.parseInt(ymd[2]);
        return f(year) && month > 2 ? preMd[month] + day + 1 : preMd[month] + day;
    }

    public static boolean f(int year){
        if(year % 400 == 0){
            return true;
        }
        if(year % 4 == 0 && year % 100 != 0){
            return true;
        }
        return false;
    }
}
