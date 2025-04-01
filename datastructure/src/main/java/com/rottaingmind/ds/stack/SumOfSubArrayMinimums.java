package com.rottaingmind.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubArrayMinimums {


    // brute force
    //o(n^2)
    // space o(1)
    public int minSum(int[] a) {

        int ans = 0;
        int m = (int) 1e9 + 7;

        for (int i = 0; i < a.length; i++) {
            int minSum = Integer.MAX_VALUE;

            for (int j = i; j < a.length; j++) {
                minSum = Math.min(minSum, a[j]);
                ans = (ans % m + minSum % m) % m;
            }
        }

        return ans;
    }

    public long minSumV1(int[] a) {

        long sum = 0;

        int n = a.length;
        final int M = 1_000_000_007;


        for (int i = 0; i < n; i++) {
            int[] nsl = getNSL(a);
            int[] nsr = getNSR(a);

            int ls = nsl[i] - i;
            int rs = i - nsr[i];

            long totalWays = (long) ls * rs * a[i];

            sum = (sum % M + totalWays % M) % M;
        }

        return sum;
    }

    private int[] getNSL(int[] a) {
        int n = a.length;
        int[] nsl = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                while (!stack.isEmpty() && a[stack.peek()] >= a[i] ) {
                    stack.pop();
                }
                nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(i);
        }

        return nsl;
    }

    private int[] getNSR(int[] a) {
        int n = a.length;
        int[] nsr = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                nsr[i] = n;
            } else {
                while (!stack.isEmpty() && a[stack.peek()] > a[i] ) {
                    stack.pop();
                }
                nsr[i] = stack.isEmpty() ? n : stack.peek();
            }
            stack.push(i);
        }

        return nsr;
    }

}
