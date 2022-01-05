package com.rottaingmind.ds.stack.applications.verifybraces;


import java.util.Arrays;
import java.util.Stack;

public class MaxElementFromStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> maxStack = new Stack<>();

    public static void main(String[] args) {
        int[] arr = {15, 9, 3, 67, 12, 45, 111, 90, 56};
        MaxElementFromStack stack = new MaxElementFromStack();
        Arrays.stream(arr).forEach(ele -> stack.processMaxInStack(ele));
        System.out.println(stack.getMax());

    }

    private void processMaxInStack(int element) {
        mainStack.push(element);

        if (maxStack.isEmpty() || maxStack.peek() < element) {
            maxStack.push(element);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    private Integer getMax() {
        return maxStack.pop();
    }
}
