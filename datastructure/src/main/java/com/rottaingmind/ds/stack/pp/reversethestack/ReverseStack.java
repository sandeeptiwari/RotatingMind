package com.rottaingmind.ds.stack.pp.reversethestack;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseStack {

    public static void reverse(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int data = stack.pop();
        reverse(stack);
        pushBottomRecursion(data, stack);
    }


    public static void pushBottomRecursion(int ele, Deque<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(ele);
            return;
        }

        int data = stack.pop();
        pushBottomRecursion(ele, stack);
        stack.push(data);
    }

    public static void main(String[] args) {
        Deque<Integer> temp = new LinkedList<>();
        temp.push(1);
        temp.push(2);
        temp.push(3);

        reverse(temp);

        System.out.println(temp.pop());
        System.out.println(temp.pop());
        System.out.println(temp.pop());
    }
}
