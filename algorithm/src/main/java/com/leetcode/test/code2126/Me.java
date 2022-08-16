package com.leetcode.test.code2126;

import java.util.TreeMap;

/**
 * 有序表
 */
public class Me {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int a : asteroids){
            if(map.containsKey(a)){
                map.put(a, map.get(a) + 1);
            }else{
                map.put(a, 1);
            }
        }
        //，若成长的行星比最大的小行星大，则一定可以成功
        int max = map.lastKey();
        while(mass < max){
            Integer pos = map.floorKey(mass);
            if(pos == null){
                //没有这样的小行星了
                return false;
            }
            map.put(pos, map.get(pos) - 1);
            if(map.get(pos) == 0){
                map.remove(pos);
            }
            mass += pos;
        }
        return true;
    }
}
