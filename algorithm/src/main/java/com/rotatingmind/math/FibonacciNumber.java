package com.rotatingmind.math;

public class FibonacciNumber {

    public static void main(String[] args) {
        printFibonacciNumbers(5);
    }


    public static void printFibonacciNumbers(int n) {
        System.out.print("0, 1, ");
        int a = 0, b = 1, c = 0;
        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + ", ");
        }
    }

    public static int findNthFibonacci(int n) {

        if(n == 0 || n == 1) return n;

        int a = 0, b = 1, c = 0;

        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
