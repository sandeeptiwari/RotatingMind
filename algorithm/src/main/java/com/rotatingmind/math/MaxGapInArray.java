package com.rotatingmind.math;


import java.util.BitSet;

/**
 * Maximum consecutive diff between ads ele
 * a[] = {3, 6, 9, 1}
 * sort it
 * a[] = {1, 3, 6, 9} => not max diff between
 *
 * we can iterate and check each gam and consider max gap
 *
 * but lets say min = 1 and max is 7 lets  say what would be 3rd element between 1st and max ele
 * if will choose ele 2
 * 1 2 ... 7
 * gap = 5
 *
 * L = 10^10 R = 10^10 + 500
 * [L, R] primes between L to R, if we want to count all primes between L to R
 * -> int k = L / p[i] if it's not completely divide then get ciel of K = Math.ciel(K) just greater = to that number
 * -> int k = Math.ceil(L * 1.0 / p[i])
 * Here Max range value is R so we need to find primes between 1 to underroot(R) only
 * TC = root(R) * (log ( log root(R)))
 * TC between L to R = (R-L)(log ( log root(R))
 * space required only R - L to store that range values
 * int[] a = {L -L, (L+1) -L, (L+2) -L ..... (L + R) - L}
 */
public class MaxGapInArray {

    public static void main(String[] args) {
        double L = Math.pow(10, 11), R = Math.pow(10, 11) + 500;
        boolean[] isPrimes = new boolean[(int)(R - L)];

        int[] allPrimes = getPrimes();
        for (int i = 0; i < isPrimes.length; i++) {
            double k = Math.ceil(1.0 * L) / allPrimes[i];

            for (int j = Math.max((int)k, 2); allPrimes[i] * j <= R; j++) {
                isPrimes[(int)(allPrimes[i] * j - L)] = false;
            }
        }
    }


    public static int[] getPrimes() {
        //boolean[] isPrime = new boolean[(long)Math.pow(10, 6) + 1] -> cant declare array size more that 10 to the poiwer 6

        BitSet isPrime = new BitSet((int)Math.pow(10, 6) + 1);
        isPrime.set(0, (int)Math.pow(10, 6) + 1, true);
        isPrime.set(0, false);
        for (int i = 2; i * i < Math.pow(10, 6); i++) {

            if (isPrime.get(i)) {
                for (int j = i; i * j <= Math.pow(10, 6) ; j++) {
                    isPrime.set(i * j, false);
                }
            }
        }
        int j = 0;
        int primeCount = isPrime.stream().mapToObj(isPrime::get).mapToInt(bit -> bit ? 1 : 0).sum();
        int[] primes = new int[primeCount];
        for (int i = 0; i < Math.pow(10, 6); i++) {
            if (isPrime.get(i)) {
                primes[j++] = i;
            }
        }
        return primes;
    }

    private static boolean checkPrime(int num) {
        boolean isPrime = true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
