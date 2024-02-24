package com.rottaingmind.ds.stack.applications.twostackusingsamearray;

public class Main {

    public static void main(String[] args) {
        TwoStack stack = new TwoStack();
        stack.push1(1);
        stack.push1(2);
        stack.push1(3);

        stack.push2(4);
        stack.push2(5);
        stack.push2(6);
        stack.push2(7);
        stack.push2(8);
        stack.push2(9);
        stack.push2(10);
        //stack.push2(11);

        System.out.println("pop from stack 2 " + stack.pop2());
        System.out.println("pop from stack 1 " + stack.pop1());
        System.out.println("pop from stack 1 " + stack.pop1());
        System.out.println("pop from stack 1 " + stack.pop1());
        System.out.println("pop from stack 1 " + stack.pop1());
    }
}
