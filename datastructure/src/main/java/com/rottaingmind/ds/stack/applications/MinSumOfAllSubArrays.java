package com.rottaingmind.ds.stack.applications;

import java.util.*;

/**
 * Problem Statement :: find the sum of min ele of every subarray
 * Given an array of integers arr, find the sum of min(b), where b ranges over every
 * (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
 */
public class MinSumOfAllSubArrays {

    //o(n^2)
    // space o(1)
    public int sum(int[] a) {
        int n = a.length;
        int ans = 0;
        //                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   double m = Math.pow(10, 9) + 7;
         int m = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                min = Math.min(min, a[j]);
                ans = (int)((ans % m + min % m) % m);
            }
        }
        return ans;
    }

    /**
     * Instead of considering all the sub array, can we consider contribution of individual ele into all subarray
     * e.g. ....  2, 7, 9, 6, 5, 10, 6, 9, 4
     *
     * if starting point is 2, its not possible min ele would be 5, in similar fashion if ending point is 4, its not possible
     * min ele would be 5
     *
     * Now sandwich part is remaining, you can see 2 is previous smaller ele and 4 would be next smaller element
     *
     * Now if we consider any subarray which passes through 5 and doest crosses 7 and 9 in sandwich area [7, 9, 6, 5, 10, 6, 9]
     * will deffinitely 5 would be as min ele
     *
     * total sub array = total no of choice for starting ele would be 4 [7, 9, 6, 5]
     *  and total number of ending ele would be 4 = [5, 10, 6, 9]
     *  1- [5, 5/10/6/9]
     *  2- [9, 5/10/6/9]
     *  3- [6, 5/10/6/9]
     *  4- [7, 5/10/6/9]
     * 4 X 4 = 16
     */
    public static int sumByReverseLookup(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        int ans = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.fill(pse, -1);
        Arrays.fill(nse, n);

        for(int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                pse[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }

        int mod = (int) 1e9 + 7;

        for(int i = 0; i < n; i++) {
            ans += (long) (i - pse[i]) * (nse[i] - i) % mod * arr[i] % mod;
            ans%=mod;
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        int res = sumByReverseLookup(arr);
        System.out.println("Result is: " + res);
    }
}
