package com.rotatingmind.math.primenumber;

/**
 * if we have 1 which we can cut and after 1 first number 100% prime so we can take 2 as well
 * now all multiple of 2 must be non prime so we can cut them as well
 * o (n log(logn))
 */
public class PrintAllPrimeCutAndNonCut {


    //Sieve of Eratosthems
    public static void printAllPrimeNumber(int n) {

        int[] primes = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            primes[i] = 1;
        }
        primes[1] = 0;

        for (int i = 2; i*i <= n; i++) {
            if (primes[i] == 1) {
                for (int j = i; i * j <= n; j++) {
                    primes[i*j] = 0;
                }
            }
        }

    }
}
