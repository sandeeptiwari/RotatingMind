package com.rottaingmind.ds.stack.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicIncreasing {
    
    
    private static Deque<Integer> mis(int[] a) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = a.length;

        for (int i = 0; i < n; i++) {

            while(!stack.isEmpty() && a[stack.peek()] > a[i]) {
                  stack.pop();
            }

            stack.push(i);
        }

        return stack;
    }

    public static void main(String[] args) {
        int[] a= new int[]{4, 2, 5, 1, 3};
        Deque<Integer> stack = mis(a);
        stack.stream().mapToInt(index -> a[index]).forEach(System.out::println);
    }
}
