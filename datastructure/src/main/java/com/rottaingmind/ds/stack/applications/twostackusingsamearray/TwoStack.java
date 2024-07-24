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

/**
 * int st = -1;
 * //Function to push an integer into the stack1.
 * void twoStacks::push1(int x) {
 *     if (top1 + 1 < top2) {
 *         arr[top1 + 1] = x;
 *         top1 += 1;
 *     }
 * }
 *
 * //Function to push an integer into the stack2.
 * void twoStacks::push2(int x) {
 *     if (st == -1) {
 *         st = top2;
 *     }
 *     if (top2 - 1 > top1) {
 *         arr[top2 - 1] = x;
 *         top2 -= 1;
 *     }
 * }
 *
 * //Function to remove an element from top of the stack1.
 * int twoStacks::pop1() {
 *     int ans;
 *     if (top1 >= 0) {
 *         ans = arr[top1];
 *         top1--;
 *     } else {
 *         return -1;
 *     }
 *     return ans;
 * }
 *
 * //Function to remove an element from top of the stack2.
 * int twoStacks::pop2() {
 *     int ans;
 *     if (top2 < st) {
 *         ans = arr[top2];
 *         top2++;
 *     } else {
 *         return -1;
 *     }
 *     return ans;
 * }
 */
