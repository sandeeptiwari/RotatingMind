package com.rotatingmind.math.primenumber;

import java.util.Arrays;

/**
 * 24 = p1 X P2...Pn
 * where p1, p2 all are prime numbers
 *  24 = 2 X 2 X 2 X 3
 */
public class PrimeFactorization {
    
    
    public void printAllPrimeFactorizations(int n) {
        for (int i = 2; i <= n; i++) {
            while(n% i == 0) {
                System.out.println(i);
                n = n / i;
            }
        }
    }


    /**
     * loop over instead n just till sqrt of n and in last check if remaining is 1 then stop else anything will be prime
     * 404 = 2 X 2 X 101
     *
     * o ( root of (n) X logn base 2) approx o (roor (n))
     * n, n/2 n/x = log n of base 2
     * @param n
     */
    public void printAllPrimeFactorizationsV1(int n) {
        for (int i = 2; i * i <= n; i++) {
            while(n% i == 0) {
                System.out.println(i);
                n = n / i;
            }
        }

        if (n != 1) {
            System.out.println(n);
        }
    }

    public void printAllPrimeFactorizationsV2(int n) {

        int[] primes = new int[n+1];
        Arrays.fill(primes, 1);

        int[] spf = new int[n+1];
        Arrays.fill(spf, -1);
        primes[1] = 0;
        for (int i = 2; i * i <= n; i++) {
            if (primes[i] == 1) {
                for (int j = i; i*j <= n; j++) {
                    spf[i*j] = i;
                    primes[i*j] = 0;
                }
            }
        }
        int n1 = n;
        while (spf[n1] != -1) {
            System.out.println(spf[n1]);
            n1 = n1/spf[n1];
        }

        if (n1 != 1) {
            System.out.println(n1);
        }
    }
}
