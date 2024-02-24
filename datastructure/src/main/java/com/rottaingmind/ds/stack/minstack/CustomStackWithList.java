package com.rottaingmind.ds.stack.minstack;

import java.util.ArrayList;
import java.util.List;

public class CustomStackWithList {
    private List<Integer> data;
    private List<Integer> minStack;

    public CustomStackWithList() {
        data = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int element) {
        data.add(element);
        if (minStack.isEmpty() || element <= minStack.get(minStack.size() - 1)) {
            minStack.add(element);
        }
    }

    public int pop() {
        if (data.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int top = data.remove(data.size() - 1);
        if (top == minStack.get(minStack.size() - 1)) {
            minStack.remove(minStack.size() - 1);
        }
        return top;
    }

    public int peek() {
        if (data.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data.get(data.size() - 1);
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.get(minStack.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
