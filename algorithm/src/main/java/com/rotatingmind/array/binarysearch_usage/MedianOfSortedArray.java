package com.rotatingmind.array.binarysearch_usage;

public class MedianOfSortedArray {

    public static double median(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return median(b, a);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }

    public static double medianV1(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int[] res = new int[n1 + n2];
        int i = 0;
        int j = 0, k = 0;
        double median = 0;

        while (i < n1 && j < n2) {

            if (a[i] <= b[j]) {
                res[k++] = a[i];
                i++;
            } else {
                res[k++] = b[j];
                j++;
            }

        }

        while (i < n1) {
            res[k++] = a[i];
            i++;
        }
        while (j < n2) {
            res[k++] = b[j];
            j++;
        }

        int size = n1 + n2;

        if (size % 2 == 0) {
            int m1 = size / 2;
            median = (res[m1] + res[m1 - 1]) / 2f;
        } else {
            int m = size / 2;
            median = res[m];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        int[] a1 = {1, 3};
        int[] b1 = {2};
        int[] a2 = {1, 2};
        int[] b2 = {3, 4};
        System.out.println("The median of two sorted arrays is " + medianV1(a2, b2));
    }
}
