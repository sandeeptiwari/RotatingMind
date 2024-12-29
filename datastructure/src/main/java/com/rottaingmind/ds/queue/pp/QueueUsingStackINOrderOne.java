package com.rottaingmind.ds.queue.pp;

import java.util.Stack;

public class QueueUsingStackINOrderOne {
    private Stack<Integer> stack = new Stack<>(); // push
    private Stack<Integer> tmpStk = new Stack<>(); // pop
    private int frontEle;
    private int bottomOfTemp;

    public void enQueue(int value) {
        if (stack.isEmpty() && tmpStk.isEmpty()) {
            frontEle = value;
        } else if (tmpStk.isEmpty()) {
            bottomOfTemp = value;
        }
        stack.push(value);
    }

    public int deQueue() {
        if (tmpStk.isEmpty()) {
            while (!stack.isEmpty()) {
                tmpStk.push(stack.pop());
            }
        }
        int ele = tmpStk.pop();
        if (!tmpStk.isEmpty()) {
            frontEle = tmpStk.peek();
        } else if (!stack.isEmpty()) {
            frontEle = bottomOfTemp;
        }
        return ele;
    }

    public int peek() {
        return frontEle;
    }

    public boolean isEmpty() {
        return stack.isEmpty() && tmpStk.isEmpty();
    }
}
