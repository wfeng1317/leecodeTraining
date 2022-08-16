package com.leetcode.test.code641;

public class Me {
    class MyCircularDeque {
        int[] queue;
        int left;
        int right;
        int K;

        public MyCircularDeque(int k) {
            K = k;
            queue = new int[k];
            left = 0;
            right = -1;
        }

        public boolean insertFront(int value) {
            if(isFull()){
                return false;
            }
            if(isEmpty()){
                queue[left] = value;
                right = left;
                return true;
            }
            left = left == 0 ? K - 1 : left - 1;
            queue[left] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            }
            if(isEmpty()){
                queue[left] = value;
                right = left;
                return true;
            }
            right = right == K - 1 ? 0 : right + 1;
            queue[right] = value;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            if(right == left){
                right = -1;
                return true;
            }
            left = left == K - 1 ? 0 : left + 1;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }
            if(right == left){
                right = -1;
                return true;
            }
            right = right == 0 ? K - 1 : right - 1;
            return true;
        }

        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return queue[left];
        }

        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            return queue[right];
        }

        public boolean isEmpty() {
            return right == -1;
        }

        public boolean isFull() {
            return right != -1 && (right + 1 == left || (left == 0 && right == K - 1));
        }
    }
}
