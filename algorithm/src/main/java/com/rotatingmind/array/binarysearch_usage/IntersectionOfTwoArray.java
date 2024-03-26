package com.rotatingmind.array.binarysearch_usage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntersectionOfTwoArray {

    public static int[] intersection(int[] arr1, int[] arr2) {
        int[] parent = arr1.length >= arr2.length ? arr1 : arr2;
        int[] child = arr1.length >= arr2.length ? arr2 : arr1;

        Set<Integer> set = Arrays.stream(parent).boxed().collect(Collectors.toSet());

        Integer[] set1 = Arrays.stream(child).filter(set::contains)
                .boxed()
                .collect(Collectors.toSet()).toArray(Integer[]::new);
        int[] result = new int[set1.length];

        for (int i = 0; i < set1.length; i++) {
            result[i] = set1[i].intValue();
        }
        return result;
    }

    public static int[] intersectionV2(int[] arr1, int[] arr2) {
        Set<Integer> results = new HashSet<>();
        int[] parent = arr1.length >= arr2.length ? arr1 : arr2;
        Arrays.sort(parent);
        int[] child = arr1.length >= arr2.length ? arr2 : arr1;

        for (int i = 0; i < child.length; i++) {

            if (binarySearch(arr2, child[i])) {
                results.add(child[i]);
            }
        }

        int[] result = new int[results.size()];
        int i = 0;
        for (int num : results) {
            result[i++] = num;
        }
        return result;

    }

    private static boolean binarySearch(int[] arr2, int num) {
        int start = 0;
        int last = arr2.length -1;

        while (start <= last) {
            int mid = (start + last) / 2;

            if (arr2[mid] == num) {
                return true;
            } else if (num < arr2[mid]) {
                last = mid - 1;
            } else if (num > arr2[mid]) {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};

        int[] nums5 = {1};
        int[] nums6 = {1, 2};

        int[] nums7 = {4, 7, 9, 7, 6, 7};
        int[] nums8 = {5, 0, 0, 6, 1, 6, 2, 2, 4};

        int[] set = intersectionV2(nums7, nums8);
        Arrays.stream(set).forEach(System.out::print);
    }
}
