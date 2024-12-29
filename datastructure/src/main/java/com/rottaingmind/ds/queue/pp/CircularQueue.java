package com.rottaingmind.ds.queue.pp;

/**
 * imagine  array is circular
 */
public class CircularQueue {
    int[] queue = null;
    int front, rear;
    int cnt = 0;

    public CircularQueue() {
        queue = new int[10^5];
    }

    public CircularQueue(int size) {
        queue = new int[size];
    }

    public void enqueue(int item) {
        if (size() == queue.length) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        cnt++;
    }

    public int dequeue() {
        if (!isEmpty()) {
            front = (front + 1) % queue.length;
            cnt--;
            return queue[front];
        }
        throw new RuntimeException("Queue is empty");
    }

    public int peek() {
        if (!isEmpty()) {
            return queue[front];
        }
        throw new RuntimeException("Queue is empty");
    }

    public int size() {
        return rear - front + 1;
    }

    //underflow
    public boolean isEmpty() {
        if (cnt == 0) {
            return true;
        }
        return false;
    }

    //overflow
    public boolean isFull() {
        if (cnt == queue.length) {
            return true;
        }
        return false;
    }
}
