package com.leetcode.test.code232;

public class Me {
    class MyQueue {
        int[] head;
        int hSize;
        int[] tail;
        int tSize;

        public MyQueue() {
            head = new int[100];
            tail = new int[100];
            hSize = 0;
            tSize = 0;
        }

        public void push(int x) {
            tail[tSize++] = x;
        }

        public int pop() {
            if(hSize == 0){
                for(int i = tSize - 1; i >= 0; i--){
                    head[hSize++] = tail[i];
                }
                tSize = 0;
            }
            return head[--hSize];
        }

        public int peek() {
            if(hSize == 0){
                for(int i = tSize - 1; i >= 0; i--){
                    head[hSize++] = tail[i];
                }
                tSize = 0;
            }
            return head[hSize - 1];
        }

        public boolean empty() {
            return hSize == 0 && tSize == 0;
        }
    }
}
