package com.rottaingmind.ds.queue.pp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.IntStream;

/**
 * Given an arr[n] where int k; k <= n
 * consider every window of size k
 * find the maximum in each window.
 *
 * in window size is k and starting index i then ending index would be i + k -1
 *
 * starting index = 0, 1, 2... n - k
 * total window   = n-k +1 windows
 * TC = o((N-k+1) * k)
 *
 * brute force
 *
 *
 */
public class SlidingWindowMax {

    public void printMax(int[] a, int k) {
        int n = a.length;

        for (int i = 0; i < n - k; i++) {
            System.out.println(getMax(a, i, i +k -1));
        }
    }

    private int getMax(int[] a, int i, int j) {
        if (i > j) {
            return 0;
        }
        return IntStream.range(i, j + 1).mapToObj(index -> a[index]).max(Comparator.naturalOrder()).orElse(0);
    }


    public static void insertAtBack(int[] a, Deque<Integer> deque, int i) {
        while(!deque.isEmpty() && a[deque.peekLast()] <= a[i]) {
            deque.pollLast();
        }
        deque.addLast(i);
    }


    public static int[] printMax1(int[] a, int k) {
        Deque<Integer> deque = new ArrayDeque<>(k);
        int n = a.length;
        int[] ans = new int[n - k + 1];
        int j = 0;

        for (int i = 0; i < k ; i++) {
            insertAtBack(a, deque, i);
        }

        for (int i = k; i < n ; i++) {
            if (!deque.isEmpty()) {
                ans[j++] = a[deque.peekFirst()];
                if (deque.peekFirst() == (i - k)) {
                    deque.pollFirst();
                }
            }
            insertAtBack(a, deque, i);
        }
        if (!deque.isEmpty()) {
            ans[j++] = a[deque.pollFirst()];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] a = { 10, 1, 2, 9, 7, 6, 5, 11, 3 };
        int k = 4;
        int[] res = printMax1(a, k);
        System.out.println(Arrays.toString(res));
    }

}
