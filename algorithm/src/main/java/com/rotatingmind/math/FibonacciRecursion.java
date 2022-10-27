package com.rotatingmind.math;

public class FibonacciRecursion {
    public static void main(String[] args) {

        System.out.println(U(5));
    }


    public static int U(int n) {
        if(n == 0 || n == 1) return 1;

        return U(n-1) + U( n - 2);
    }
}
