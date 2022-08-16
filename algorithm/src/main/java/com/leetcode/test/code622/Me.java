package com.leetcode.test.code622;

public class Me {
    int[] queue;
    int head;
    int tail;
    int n;

    public Me(int k) {
        queue = new int[k];
        n = k;
        head = -1;
        tail = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        queue[tail] = value;
        head = head == -1 ? tail : head;
        tail = tail == n - 1 ? 0 : tail + 1;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (tail == head + 1 || (tail == 0 && head == n - 1)) ? -1 : (head == n - 1 ? 0 : head + 1);
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[tail == 0 ? n - 1 : tail - 1];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head != -1 && tail == head;
    }
}
