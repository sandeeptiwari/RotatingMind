package com.rottaingmind.recursion;

public class Demo1 {

    private static void func(int n) {

        if (n == 1) System.out.print(1 + " ");
        else {
            System.out.print(n + " ");
            func(n -1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        func(4);
    }
}
