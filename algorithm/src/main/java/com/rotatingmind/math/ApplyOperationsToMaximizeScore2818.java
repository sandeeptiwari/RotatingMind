package com.rotatingmind.math;

import java.util.*;
import java.util.stream.IntStream;

record PairByIndex(int ele, int index) {}
public class ApplyOperationsToMaximizeScore2818 {

    final int MOD = (int) 1e9 + 7;

    private long findPower(long a, long b) {
        if (b == 0) return 1;
        long half = findPower(a, b / 2);
        long result = (half * half) % MOD;
        if (b % 2 == 1) {
            result = (result * a) % MOD;
        }
        return result;
    }

    /**
     * 1. Calculate Prime Scores
     * 2. Number is multiplied to score
     * 3. Greedily I would want to multiply bigger number to maximize my score.
     * 4.
     */
    public int maximumScore(List<Integer> nums, int k) {

        int n = nums.size();

        //PrimeScore
        List<Integer> primeScores = getPrimeScore(nums);

        //nextGreater
        List<Integer> nse = nextGreaterElement(primeScores);

        //previousGreater
        List<Integer> pse = previousGreaterElement(primeScores);

        // all sub arrays
        long[] subArrays = new long[n];

        for (int i = 0; i < n; i++) {
            subArrays[i] = (long)(nse.get(i) - i) * (i - pse.get(i));
        }

       // sort by index

        List<PairByIndex> pairs = new ArrayList<>();

        var sortedNums = IntStream.range(0, nums.size())
                .mapToObj(i -> new PairByIndex(nums.get(i), i))
                .sorted(Comparator.comparingInt(PairByIndex::ele))
                .toList();

        long score = 1;
        int idx = 0;

        while (k > 0) {
            int num = sortedNums.get(idx).ele();
            int i = sortedNums.get(idx).index();

            long operations = Math.min((long) k, subArrays[i]);

            score = (score * findPower(num, operations)) % MOD;

            k -= operations;
            idx++;
        }

        return (int) score;
    }


    private List<Integer> getPrimeScore(List<Integer> nums) {

        int maxEle = nums.stream().max(Integer::compareTo).orElse(0);
        List<Integer> allPrimes = getAllPrimes(maxEle);

        List<Integer> result = new ArrayList<>(Collections.nCopies(nums.size(), 0)); // Initialize with 0s
        int n = nums.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            for (int prime : allPrimes) {

                if (prime * prime > num) {
                    break;
                }

                if (num % prime != 0) {
                    continue;
                }

                count++;

                while (num % prime == 0) {
                    num = num / prime;
                }
            }

            if (num > 1) {
                if (num > 1) count++; // Count remaining prime factor if any
                result.set(i, count); // Update result list
            }
        }

        return result;
    }

    private  List<Integer> getAllPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    private List<Integer> nextGreaterElement(List<Integer> primeScores) {
        int n = primeScores.size();
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && primeScores.get(stack.peek()) <= primeScores.get(i)) {
                stack.pop();// Remove smaller elements
            }

            int v = stack.isEmpty() ? -1 : stack.peek(); // Set the next greater element
            result.add(v);
            stack.push(i);// Push the current number for future comparisons
        }
        return result;
    }

    private List<Integer> previousGreaterElement(List<Integer> primeScores) {
        int n = primeScores.size();
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && primeScores.get(stack.peek()) < primeScores.get(i)) {
                stack.pop(); // Remove smaller elements
            }
            var v = stack.isEmpty() ? n : stack.peek(); // Set the next greater element
            result.add(v);
            stack.push(i); // Push the current number for future comparisons
        }
        return result;
    }
}
