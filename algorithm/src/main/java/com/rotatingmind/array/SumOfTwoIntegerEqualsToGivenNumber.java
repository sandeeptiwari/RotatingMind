package com.rotatingmind.array;

import java.util.*;

public class SumOfTwoIntegerEqualsToGivenNumber {
    static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    private static int[] findPair(int arr[], int sumValue) {
        int[] results = new int[2];
        if (arr.length == 0) return null;

        if (arr.length < 2) return null;

        for (int i = 0, j = arr.length - 1; i < arr.length; ) {
            if (i < j) {
                if (arr[i] + arr[j] == sumValue) {
                    results[0] = i;
                    results[1] = j;
                    j--;
                    i++;
                } else {
                    j--;
                }
            } else {
                i++;
                j = arr.length -1;
            }
        }

        return results;
    }

    private static List<Pair> checkPair(int[] a, int targetSum) {
        List<Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> keyByIndex = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int key = targetSum - a[i];
            if (keyByIndex.containsKey(a[i])) {
                pairs.add(new Pair(a[i], key));
            } else {
                keyByIndex.put(key, a[i]);
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 7, 9, 10, 12};
        //int[] pair = findPair(arr, 8);
       // System.out.println(pair[0] + " " + pair[1]);

        List<Pair> pairs = checkPair(arr, 8);
        System.out.println(pairs);
    }
}
