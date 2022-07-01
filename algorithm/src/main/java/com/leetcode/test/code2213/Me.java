package com.leetcode.test.code2213;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 自写堆
 * 51/57
 */
public class Me {

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        char[] str = s.toCharArray();
        int k = queryIndices.length;
        int[] res = new int[k];
        //记录每个位置结尾的最长子字符串
        int[] endLong = new int[n];
        ArrayList<C> heap = new ArrayList<>();
        //位置与结尾长度的映射
        HashMap<Integer, C> map1 = new HashMap<>();
        //结尾长度与堆位置的映射
        HashMap<C, Integer> map2 = new HashMap<>();
        endLong[0] = 1;
        C c = new C(endLong[0]);
        map1.put(0, c);
        heap.add(c);
        map2.put(c, 0);
        for(int i = 1; i < n; i++){
            if(str[i] == str[i - 1]){
                endLong[i] = endLong[i - 1] + 1;
            }else{
                endLong[i] = 1;
            }
            c = new C(endLong[i]);
            map1.put(i, c);
            map2.put(c, heap.size());
            heap.add(c);
            heapInsert(heap, heap.size() - 1, map2);
        }
        //一个位置改变看它能影响的范围
        for(int i = 0; i < k; i++){
            int swap = queryIndices[i];
            char pre = str[swap];
            str[swap] = queryCharacters.charAt(i);
            if(swap == 0 || str[swap] != str[swap - 1]){
                endLong[swap] = 1;
            }else{
                endLong[swap] = endLong[swap - 1] + 1;
            }
            map1.get(swap).value = endLong[swap];
            resign(heap, map2.get(map1.get(swap)), map2);
            int j = swap + 1;
            if(j < n){
                if(str[j] == str[j - 1]){
                    endLong[j] = endLong[j - 1] + 1;
                }else if(str[j] == pre){
                    endLong[j] = 1;
                }
                map1.get(j).value = endLong[j];
                resign(heap, map2.get(map1.get(j)), map2);
            }

            j++;
            while(j < n && str[j] == str[j - 1]){
                endLong[j] = endLong[j - 1] + 1;
                map1.get(j).value = endLong[j];
                resign(heap, map2.get(map1.get(j)), map2);
                j++;
            }
            res[i] = heap.get(0).value;
        }
        return res;
    }

    static class C{
        int value;
        public C(int v){
            value = v;
        }
    }

    void resign(ArrayList<C> heap, int index, HashMap<C, Integer> map2){
        heapInsert(heap, index, map2);
        heapify(heap, index, map2);
    }

    void heapInsert(ArrayList<C> heap, int index, HashMap<C, Integer> map2){
        while(heap.get(index).value > heap.get((index - 1) / 2).value){
            swap(heap, index, (index - 1) / 2, map2);
            index = (index - 1) / 2;
        }
    }

    void heapify(ArrayList<C> heap, int index, HashMap<C, Integer> map2){
        int left = index * 2 + 1;
        while(left < heap.size()){
            int largest = left + 1 < heap.size() && heap.get(left + 1).value > heap.get(left).value ? left + 1 : left;
            largest = heap.get(largest).value > heap.get(index).value ? largest : index;
            if(largest == index){
                break;
            }
            swap(heap, largest, index, map2);
            index = largest;
            left =  index * 2 + 1;
        }
    }

    void swap(ArrayList<C> heap, int a, int b, HashMap<C, Integer> map2){
        C ca = heap.get(a);
        C cb = heap.get(b);
        heap.set(a, cb);
        heap.set(b, ca);
        map2.put(ca, b);
        map2.put(cb, a);
    }
}
