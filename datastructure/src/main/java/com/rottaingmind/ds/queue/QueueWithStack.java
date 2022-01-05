package com.rottaingmind.ds.queue;

import java.util.Stack;

public class QueueWithStack<T> {
    // use one stack for enqueue operation
    private Stack<T> enqueueStack;

    // use one stack for dequeue operation
    private Stack<T> dequeueStack;

    public QueueWithStack() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    public void enQueue(T data) {
        enqueueStack.push(data);
    }

    public T dequeue() {
        // if enQueueStack is empty
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            throw new RuntimeException("Stack is empty...");
        }
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
       return dequeueStack.pop();
    }
}
