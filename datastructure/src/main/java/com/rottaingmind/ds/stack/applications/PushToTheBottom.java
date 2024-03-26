package com.rottaingmind.ds.stack.applications;

import java.util.Deque;
import java.util.LinkedList;

public class PushToTheBottom {

    /**
     * if no of ele is n, every stack oper O(n)
     * @param ele
     * @param stack
     */
    public void pushBottom(int ele, Deque<Integer> stack) {
        Deque<Integer> temp = new LinkedList<>();

        while(!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        stack.push(ele);

        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }
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
        pushBottomRecursion(4, temp);
        System.out.println("Pop :: " + temp.pop());
    }
}
