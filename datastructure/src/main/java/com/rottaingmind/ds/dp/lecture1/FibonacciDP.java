package com.rottaingmind.ds.dp.lecture1;

public class FibonacciDP {

    private int fib(int n, int[] arr) {
        if (n < 2) return n;

        // If already computed, return the value from the array
        if (arr[n] != 0) return arr[n];

        // Compute the value and store it in the array
        arr[n] = fib(n - 1, arr) + fib(n - 2, arr); // solve an dstore

        return arr[n];
    }

    public static void main(String[] args) {
        int [] f = new int[7];// For fib(5), we need size 6 (indices 0 to 5)

        int fibonacci = new FibonacciDP().fib(6, f);

        System.out.println(fibonacci);
    }
}
