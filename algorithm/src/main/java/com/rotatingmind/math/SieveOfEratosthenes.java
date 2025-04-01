package com.rotatingmind.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {


    //Sieve -> chhanni
    private int[] getAllPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {

            if (isPrime[i]) {
                for (int j = 2; i * j <= n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {

    }
}
