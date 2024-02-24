package com.rottaingmind.ds.stack.pp.nextlargestele;

import java.util.Arrays;

public class NextLargestElement {


    public static int[] nextGreatestElements(int[] arr) {
        int len = arr.length;
        int[] nge = new int[len];
        Arrays.fill(nge,-1);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] < arr[j]) {
                    nge[i] = arr[j];
                    break;
                }
            }
        }
        return nge;
    }


    public static void main(String[] args) {
        int[] a = {4, 5, 2, 25};
        int[] ints = nextGreatestElements(a);
        Arrays.stream(ints).forEach(System.out::println);
    }


}
