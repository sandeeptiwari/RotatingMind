package com.rotatingmind.array.binarysearch_usage;

public class Practice {

    public static int firstOcc(int key, int[] arr) {
        int low = 0, high = arr.length - 1;
        int mid = -1;
        while (low <= high) {

            mid = (low + high) / 2;

            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                if (mid == 0) return mid;

                if (arr[mid - 1] != key) {
                    return mid;
                } else {
                    high = mid -1;
                }
            }
        }
        return mid;
    }



    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 5, 5, 5, 5, 9, 11};
        int firstOcc = firstOcc(5, arr);
        //int lastOcc = lastOcc(5, arr);
        System.out.println("First occ " + firstOcc);
        //System.out.println("Last occ " + lastOcc);
    }

}
