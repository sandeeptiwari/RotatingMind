package com.rotatingmind.array;

public class RotateArrayByK {

    public void rotateByK(int[] a, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = a[i];

            a[i] = a[j];
            a[j] = temp;

        }
    }

    public void rotate(int arr[], int k) {
        rotateByK(arr, 0, k - 1);//1st roate first half k = 4
        rotateByK(arr, k, arr.length - 1);//2nd roate second half k = 4
        rotateByK(arr, 0, arr.length - 1);//3rd rotate whole array k = 4
    }

    public boolean isRotation1(int arr1[], int arr2[]) {
        boolean isRotate = true;

        if (arr1.length != arr2.length) {
            isRotate = false;
        }
        rotate(arr1, 3);

        for (int i = 0; i < arr1.length; i++) {

            if (arr1[i] == arr2[i]) {
                continue;
            } else {
                isRotate = false;
                break;
            }
        }

        return isRotate;
    }

    // Implement your solution below.
    public static Boolean isRotation(int[] array1, int[] array2) {
        if (array1.length != array2.length) return false;

        int key = array1[0];
        int keyLoc = -1;

        for (int i = 0; i < array2.length; i++) {
            if (array2[i] == key) {
                keyLoc = i;
                break;
            }
        }
        if (keyLoc == -1) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {

            int j = (keyLoc + i) % array1.length;

            if(array1[i] != array2[j]) return false;
        }

        return true;
    }
}
