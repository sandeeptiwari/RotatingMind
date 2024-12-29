package com.rotatingmind.array.binarysearch_usage;

import java.util.Arrays;

public class KthSmallestNumberInArray {

    public static void main(String[] args) {
        extractedV1();
    }

    /**
     *      < k                   >= k
     * 10---------------55----------------------70
     * @param a
     */
    private static int byUsingBinarySearch(int[] a, int k) {
        int l = Arrays.stream(a).min().getAsInt();
        int h = Arrays.stream(a).max().getAsInt();
        int n = a.length;

        while (l <= h) {
            int mid = (l + h) / 2;

            // ans must lie in right side because count of smaller num than given number a(mid) is less than k
            if (func(a, a[mid], n) < k) {
                l = mid + 1;
            } else if (func(a, a[mid], n) >= k) {

                if (func(a, a[mid-1], n) < k) {
                    return mid;
                } else {
                    h = mid -1;
                }
            }

        }
        return -1;
    }

    //its monotonic function
    private static int func(int[] a, int x, int n) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {

            if (a[i] <= x) {
                cnt++;
            }
        }
        return cnt;
    }

    private static void extractedV1() {
        int[] a = {40, 10, 10, 30, 40, 20, 50, 70, 50};
        int k = 6;
        int n = a.length;
        // Step -1 sort the array
        //return value at k -1 index that would be output

        /**
         * But if array would we read only then cant sort the array in that case we have to take temp array
         * and copy ele one by one and sort and return k - 1 but if no extra space allowed
         *
         * If there is an element which is actually the answer then it will come at index k -1, all element less that x will come till k
         *
         * case - 1: count of less than choosen number < k
         * case - 2: could is greater or equal to K
         */


        for (int i = 0; i < n; i++) {
            int smallest = 0;
            int equal = 0;

            for (int j = 0; j < (n-1); j++) {

                if (a[j] < a[i]) {
                    smallest++;
                } else if (a[j] == a[i]) {
                    equal++;
                }
            }
            int total = smallest + equal;

            //first k -1 slot occupied by some other element and kth element occupied by a[i] which is kth smallest
            // number
            if (total >= k && smallest < k) {
                System.out.println(a[i]);
                break;
            }
        }
    }
}
