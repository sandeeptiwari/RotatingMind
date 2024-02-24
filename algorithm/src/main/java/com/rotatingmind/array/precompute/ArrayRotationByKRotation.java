package com.rotatingmind.array.precompute;

public class ArrayRotationByKRotation {



    public void oneUnitOfRotation(int[] a) {
        int l = a.length;
        int temp = a[l-1];
        for (int i = l-2; i >= 0; i--) {
            a[i+1] = a[i];
        }
        a[0] = temp;
    }


    public static int[] oneUnitOfRotation1(int[] a) {
        int l = a.length;
        int k = 3;
        int[] temp = new int[l];

        for (int i = 0; i < l; i++) {
            temp[(i + k) % l] = a[i];
        }

        return temp;
    }

    public static void oneUnitOfRotation2(int[] arr, int d) {
        int n = arr.length;
        reverseArray(arr, 0, n-1);
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
    }

    /*private static void reverse(int[] a, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }*/

    static void reverseArray(int arr[], int start, int end)
    {
        int i;
        int temp;
        while(start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
       int[] num = {1, 2, 3, 4, 5, 6, 7};

        //int[] res = oneUnitOfRotation1(num);
        oneUnitOfRotation2(num, 2);


        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + ", ");
        }
    }

}
