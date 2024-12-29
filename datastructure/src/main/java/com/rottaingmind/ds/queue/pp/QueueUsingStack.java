package com.rottaingmind.ds.queue.pp;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tmpStk = new Stack<>();
    int frontEle;

    public void enqueue(int value) {
        if (stack.isEmpty()) {
            frontEle = value;
        }
        stack.push(value);
    }

    public int dequeue() {
       while (!stack.isEmpty()) {
           tmpStk.push(stack.pop());
       }
       int ele = tmpStk.pop();
       frontEle = tmpStk.peek();

       while (!tmpStk.isEmpty()) {
           stack.push(tmpStk.pop());
       }
       return ele;
    }

    public int peek() {
        return frontEle;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
