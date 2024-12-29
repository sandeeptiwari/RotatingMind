package com.rottaingmind.ds.queue.pp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Need to find first -ve integer in every window of size k
 *
 * 1, -2, 5, -3, 7, -9
 * k = 4
 * in w1 = -2
 * in w2 = -2
 * int w3 = -3
 * * there is no -ve in specific window just return 0
 *
 * ==> Only -ve element of a part of window will be useful element
 *
 */
public class FindFirstNegativeIntegerInEveryWindowOfSizeK {

    public static int[] findAllNegativeIntegers(int[] a, int k) {
        Deque<Integer> d = new ArrayDeque<Integer>();
        int n = a.length;
        int[] result = new int[n - k + 1];
        Arrays.fill(result, 0);

        for (int i = 0; i < k; i++) {
            if (a[i] < 0) {
                d.addFirst(i);
            }
        }

        for (int i = k; i < n; i++) {

            if (d.isEmpty()) {
                result[i - k] = 0;
            } else  {
                result[i - k] = a[d.peekLast()];

                if (d.peekLast() == i - k) {
                    d.pollLast();
                }
            }
            if (a[i] < 0) {
                d.addFirst(i);
            }
        }

        if (d.isEmpty()) {
            result[n - k] = 0;
        } else {
            result[n - k] = a[d.pollLast()];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = { 1, -2, 5, -3, 7, -9 };
        int[] allNegativeIntegers = findAllNegativeIntegers(a, 4);
        System.out.println(Arrays.toString(allNegativeIntegers));
    }

}
