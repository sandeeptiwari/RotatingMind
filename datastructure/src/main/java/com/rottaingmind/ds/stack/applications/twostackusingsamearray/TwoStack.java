package com.rottaingmind.ds.stack.applications.twostackusingsamearray;

public class TwoStack {

    private int[] stack;

    private int top1 = -1;
    private int top2 = -1;

    public TwoStack(int capacity) {
        top2 = capacity;
    }

    public TwoStack() {
        top2 = 10;
        stack = new int[10];
    }

    public void push1(int data) {
        if (top1 + 1 == top2) {
            throw new IllegalStateException("Stack_1 is overflow");
        }
        stack[++top1] = data;
    }

    public int pop1() {
        if (top1 == -1) {
            throw new IllegalStateException("Stack_1 is under overflow");
        }
        int data = stack[top1];
        top1--;
        return data;
    }

    public void push2(int data) {
        if (top2 - 1 == top1) {
            throw new IllegalStateException("Stack_2 is overflow");
        }
        stack[--top2] = data;
    }

    public int pop2() {
        if (top2 == -1) {
            throw new IllegalStateException("Stack_2 is under overflow");
        }
        int data = stack[top2];
        top2++;
        return data;
    }
}
