package com.leetcode.test.code1656;

import java.util.ArrayList;
import java.util.List;

public class Me {
    class OrderedStream {
        String[] stream;
        int ptr;
        int N;
        public OrderedStream(int n) {
            stream = new String[n + 1];
            ptr = 1;
            N = n;
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey] = value;
            List<String> res = new ArrayList<>();
            if(ptr == idKey){
                for(; ptr <= N; ptr++){
                    if(stream[ptr] == null){
                        break;
                    }
                    res.add(stream[ptr]);
                }
            }
            return res;
        }
    }
}
