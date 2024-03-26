package com.rottaingmind.ds.stack.minstack;

public class Main {

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(10);
        stack.push(10);
        stack.push(6);
        stack.push(11);
        stack.push(7);
        stack.push(5);
        stack.push(9);
        stack.push(3);
        stack.push(12);
        stack.push(1);

        System.out.println("Min : " + stack.getMin());
        System.out.println("popped : " +stack.pop());
        System.out.println("Min : " + stack.getMin());
        System.out.println("popped : " + stack.pop());
        System.out.println("popped : " +stack.pop());
        System.out.println("Min : " + stack.getMin());
    }
}
