package com.rottaingmind.ds.queue.pp;

public class CustomQueue {
    int[] queue = null;
    int front, rear;

    public CustomQueue() {
        queue = new int[10^5];
    }

    public CustomQueue(int size) {
        queue = new int[size];
    }

    public void enqueue(int item) {
        if (size() == queue.length) {
           throw new RuntimeException("Queue is full");
        }

        queue[++rear] = item;
    }

    public int dequeue() {
        if (!isEmpty()) {
            return queue[--rear];
        }
        throw new RuntimeException("Queue is empty");
    }

    public int peek() {
        if (front == rear) {
            return queue[0];
        }
        return queue[front];
    }

    public int size() {
        return rear - front + 1;
    }

    public boolean isEmpty() {
        return front > rear;
    }

}
