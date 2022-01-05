package com.rotatingmind.array;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArray {

    public int[] intersection(int arr1[], int arr2[]) {
        int parent[] = arr1.length >= arr2.length ? arr1 : arr2;
        int child[] = arr1.length >= arr2.length ? arr2 : arr1;
        return Arrays.stream(parent)
                .boxed()
                .filter(ele -> Arrays.stream(child)
                        .boxed()
                        .anyMatch(ele1 -> ele1 == ele))
                .mapToInt(ele -> ele)
                .toArray();
    }

    public static Integer[] commonElements(int[] array1, int[] array2) {
        int p1 = 0;
        int p2 = 0;
        // Need to use ArrayList because we don't know the size of the resulting
        // array yet. Note that an ArrayList is resizable.
        ArrayList<Integer> result = new ArrayList();
        while(p1 < array1.length && p2 < array2.length){
            if (array1[p1] == array2[p2]) {
                result.add(array1[p1]);
                p1 += 1;
                p2 += 1;
            }
            else if (array1[p1] > array2[p2]) {
                p2 += 1;
            } else {
                p1 += 1;
            }
        }
        // Convert the result to a regular array.
        Integer[] resultInArray = new Integer[result.size()];
        return result.toArray(resultInArray);
    }
}
