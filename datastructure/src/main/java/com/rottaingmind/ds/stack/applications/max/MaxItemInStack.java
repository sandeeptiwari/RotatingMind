package com.rottaingmind.ds.stack.applications.max;

import java.util.Stack;

public class MaxItemInStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> maxStack;

    public MaxItemInStack() {
        this.mainStack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(Integer item) {
        //push new item into mainStack
        this.mainStack.push(item);

        if (this.maxStack.size() == 0) {
            this.maxStack.push(item);
            return;
        }

        if (item > maxStack.peek()) {
            this.maxStack.push(item);
        } else {
            //if not the largest one then  we duplicate  the largest one on  the maxStack
            this.maxStack.push(this.maxStack.peek());
        }
    }

    public int pop() {
        maxStack.pop();
        return mainStack.pop();
    }

    public int getMax() {
        return this.maxStack.peek();
    }
}
