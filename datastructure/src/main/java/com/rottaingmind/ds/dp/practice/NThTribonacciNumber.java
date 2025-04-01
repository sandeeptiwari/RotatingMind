package com.rottaingmind.ds.dp.practice;

/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 */
public class NThTribonacciNumber {

    public int tribonacci(int n) {
        if (n < 3) {
            return n > 0 ? 1 : 0;
        }

        int a = 0, b = 1, c = 1;

        for (int i = 0; i < n -2; i++) {

            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }

        return c;
    }
}
