package com.rotatingmind.math.closestprime;

import java.util.*;

public class ClosestPrimeNumbers {

    public int[] closestPrimes(int left, int right) {
        // Step 1: Use Sieve of Eratosthenes to mark prime numbers
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Collect prime numbers in the given range [left, right]
        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(left, 2); i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Step 3: Find the closest prime pair
        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int p1 = -1, p2 = -1;
        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                p1 = primes.get(i - 1);
                p2 = primes.get(i);
            }
        }

        return new int[]{p1, p2};
    }

    public static void main(String[] args) {
        ClosestPrimeNumbers obj = new ClosestPrimeNumbers();
        System.out.println(obj.closestPrimes(10, 19)); // Output: [11, 13]
        System.out.println(obj.closestPrimes(1, 5));  // Output: [2, 3]
        System.out.println(obj.closestPrimes(8, 10)); // Output: [-1, -1]
    }
}

