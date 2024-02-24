package com.rotatingmind.array.binarysearch_usage;

/**
 * We have an integer array, we need to find out first and last occurance of a number in that array
 */
public class FirstAndLastOccurance {

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 5, 5, 5, 5, 9, 11};
        int firstOcc = firstOcc(5, arr);
        int lastOcc = lastOcc(5, arr);
        System.out.println("First occ " + firstOcc);
        System.out.println("Last occ " + lastOcc);
    }

    private static int firstOcc(int key, int[] arr) {
        int h = arr.length;
        int l = 0;
        int m = -1;

        while (l <= h) {

            m = (l + h) / 2;

            if (arr[m] > key) {
                h = m - 1;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                if (m == 0) return m;
                if (arr[m - 1] != key) return m;
                else h = m - 1;
            }
        }
        return -1;
    }


    private static int lastOcc(int key, int[] arr) {
        int h = arr.length;
        int l = 0;
        int m;

        while (l <= h) {

            m = (l + h) / 2;

            if (arr[m] > key) {
                h = m - 1;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                if (m == arr.length - 1) {
                    return m;
                }
                if (arr[m + 1] != key) {
                    return m;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
