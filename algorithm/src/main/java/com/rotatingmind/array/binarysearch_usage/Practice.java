package com.rotatingmind.array.binarysearch_usage;

public class Practice {

    public static int firstOcc(int key, int[] arr) {
        int n = arr.length;
        int l = 0, h = n, m = 0;
        while(l <= h) {
            m = (l + h) / 2;

            if (arr[m] > key) {
                h = m - 1;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                if (m == 0) return m;
                if (arr[m -1] != key) return m;
                else {
                    h = m - 1;
                }
            }
        }
        return m;
    }

    public static int lastOcc(int key, int[] arr) {
        int n = arr.length;
        int l = 0, h = n, m = 0;
        while(l <= h) {
            m = (l + h) / 2;

            if (arr[m] > key) {
                h = m - 1;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                if (m == n -1) return m;
                if (arr[m + 1] != key) return m;
                else {
                   l = m + 1;
                }
            }
        }
        return m;
    }



    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 5, 5, 5, 5, 5, 9, 11};
        int firstOcc = firstOcc(5, arr);
        int lastOcc = lastOcc(5, arr);
        System.out.println("First occ " + firstOcc);
        System.out.println("Last occ " + lastOcc);
        System.out.println("Number of ele " + (lastOcc - firstOcc + 1));
    }

}
