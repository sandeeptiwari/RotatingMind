package com.rottaingmind.ds.stack.applications;

import java.util.*;

/**
 * //Function to find the next greater element for each element of the array.
 */
public class NextGreaterElementInArray {

    // [4, 5, 2, 25
    //  nge = [5, 25
    public static void nextLargerElement(int[] a) {
        int n = a.length;
        int[] nge = new int[n];
        int k = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (a[i] < a[j]) {
                    nge[k++] = j;
                    break;
                }
            }

        }
        Arrays.stream(nge).forEach(ele -> System.out.println(ele));
    }

    /**
     * o(n)
     * @param a
     * @return
     */
    public static int[] nextLargerElement1(int[] a) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = a.length;
        stack.push(0);
        int[] nge = new int[n];

        for (int i = 1; i < n; i++) {

            // pop while peek is less with curr ele
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                int index = stack.pop();
                nge[index] =  a[i];
            }

            // push curr element into stack
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }

        return nge;
    }

    public static void main(String[] args) {
        //int[] a = {4, 5, 2, 25};
        int[] a = {10, 7, 4, 2, 9, 10, 11, 3, 2};
        nextLargerElement1(a);
    }
}
