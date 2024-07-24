package com.rottaingmind.ds.stack.pp;

/**
 * 1st half would be 1 stack and 2nd half would be second stack
 *
 * space utilization issue, even though space would be there other stack cant use that
 *
 * Solution::
 *
 * if both stack grows in same direction, whenever we push in stack and check top
 */
public class TwoStackInSameArray {
    private int[] stack;
    private int top1;
    private int top2;

    public TwoStackInSameArray(int size) {
        stack = new int[size];
        top1 = -1;
        top2 = size;
    }

    public void push1(int element) {
        if (top1 + 1 == top2) {
            throw new StackOverflowError("There is no space");
        }
        stack[++top1] = element;
    }

    public void push2(int element) {
        if (top2 - 1 == top1) {
            throw new StackOverflowError("There is no space");
        }
        stack[--top2] = element;
    }

    public int pop1() {
        if (top1 == -1) {
            throw new IllegalStateException("Stack 1 is empty");
        }
        return stack[top1--];
    }

    public int pop2() {
        if (top2 == stack.length) {
            throw new IllegalStateException("Stack 2 is empty");
        }
        return stack[top2++];
    }

    public static void main(String[] args) {
        TwoStackInSameArray stacks = new TwoStackInSameArray(10);

        stacks.push1(1);
        stacks.push1(2);
        stacks.push2(9);
        stacks.push2(8);
        stacks.push1(3);
        stacks.push2(7);
        stacks.push2(6);
        stacks.push1(4);
        stacks.push1(5);

        // Print the stacks for verification
        System.out.println("Stack 1 elements:");
        while (true) {
            try {
                System.out.println(stacks.pop1());
            } catch (IllegalStateException e) {
                break;
            }
        }

        System.out.println("Stack 2 elements:");
        while (true) {
            try {
                System.out.println(stacks.pop2());
            } catch (IllegalStateException e) {
                break;
            }
        }
    }
}
