package com.rottaingmind.ds.stack.pp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * implement by using existing operation in stack
 */
public class ImplementPushBottomStack {

    /**
     * 1. Approach use other temp stack just push all element from 1st stack and push new ele
     * in bottom and again push back into real stack
     * @param args
     */
    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Deque<Integer> tem = new ArrayDeque<Integer>();


        while(!stack.isEmpty()) {
            tem.push(stack.pop());
        }
        stack.push(5);

        while(!tem.isEmpty()) {
            stack.push(tem.pop());
        }

    }


    public static void pushBottomRecursion(int ele, Deque<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(ele);
            return;
        }

        int data = stack.pop();
        pushBottomRecursion(data, stack);
        stack.push(data);
    }


}
