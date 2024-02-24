package com.rottaingmind.ds.stack.minstack;

public class CustomStack {

    private int[] data;
    private int[] minStack;
    private int top = -1;
    private int minTop = -1;
    private final int capacity;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        minStack = new int[capacity];
    }

    public void push(int element) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack overflow");
        }
        data[++top] = element;
        if (minTop == -1 || element <= minStack[minTop]) {
            minStack[++minTop] = element;
        }
    }

    public int pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        if (data[top] == minStack[minTop]) {
            minTop--;
        }
        return data[top--];
    }

    public int peek() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[top];
    }

    public int getMin() {
        if (minTop == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack[minTop];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
