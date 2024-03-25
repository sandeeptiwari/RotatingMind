package com.rotatingmind.math.factors;

/**
 * Lets say we have n = 100
 * 1, 2, 4, 5 ... 50, which if num / 2
 * next factor of that number would be number only because
 * more that half a number cant be a divisible of that number
 *
 * Step -2
 *
 * N = 16
 * 1, 2, 4, 8, 18
 *
 * factors of N are symmetric about under-root(N)
 *
 * means if i is factor of number then n/i also would be factor of that number
 * here lets say i = 2 and n = 16 => 8 must be the factor = 16 / 2 = 8
 *
 * if  N = x * y then x < under-root (n) < y or y < under-root (n) < x
 */
public class PrintAllFactorsOfN {

    public void printAllFactors(int n) {

        for (int i = 1; i < n / 2; i++) {

            if (n % i == 0) {
                System.out.println(i);
            }
        }
        System.out.println(n);
    }

    // Steps - 2  o(under-root (n))
    public void printAllFactorsV1(int n) {

        for (int i = 1; i < Math.sqrt(n); i++) {

            if (n % i == 0) {
                if ( i * i == n) {
                    System.out.println(i);
                } else {
                    System.out.println(i);
                    System.out.println(n / i);
                }
            }
        }
    }

    /**
     * Given N = if num of divisors even print true else print false
     * if perfect square-root exist then total divisors = 2x + 1 where x is number of divisors before squre-root - odd
     * else it would be 2x only - even
     */
    public void evenOrOdd(int n) {

        int sqrt = (int)Math.sqrt(n);

        if (sqrt * sqrt == n) {
            System.out.println("ODD");
        } else {
            System.out.println("EVEN");
        }

    }
}
