package com.leetcode.test.code2126;


import java.util.Arrays;

/**
 * 官方贪心，注意数组长度与最大值的成乘积，比int大要使用long
 */
public class Me02 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;
        long mass1 = mass;
        Arrays.sort(asteroids);
        for(int i = 0; i < n; i++){
            if(mass1 >= asteroids[i]){
                mass1 += asteroids[i];
            }else{
                return false;
            }
        }
        return true;
    }
}
