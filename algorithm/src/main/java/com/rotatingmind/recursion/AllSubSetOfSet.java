package com.rotatingmind.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubSetOfSet {

    public static void printAllSubSet(List<Integer> a,
                               List<List<Integer>> res,
                               List<Integer> subset,
                               int index) {
        if (index == a.size()) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // Exclude the current element
        printAllSubSet(a, res, subset, index + 1);

        // Include the current element
        subset.add(a.get(index));
        printAllSubSet(a, res, subset, index + 1);

        // Backtrack
        subset.remove(subset.size() - 1);
    }

    public static void printAllSubSet(List<Integer> a, List<List<Integer>> res) {
        int n = a.size();
        for (int i = 0; i < Math.pow(2, n); i++) {
            List<Integer> subset = new ArrayList<>();

            int[] binary =    getBinaryRepresentation(i);

        }

    }

    public static int[] getBinaryRepresentation(int num) {
        int[] binaryArray = new int[32]; // 32 bits for int type in Java

        // Iterate through each bit of the integer
        for (int i = 31; i >= 0; i--) {
            // Bitwise AND operation with 1 to check the bit
            // If the i-th bit of the mask is set, include the corresponding element in the subset
            binaryArray[31 - i] = (num >> i) & 1;
        }

        return binaryArray;
    }




    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();

        subsets(nums, results, subSet, 0);

        return results;
    }

    public static void subsets(int[] nums, List<List<Integer>> results, List<Integer> subSet, int i) {

        if (i == nums.length) {
            results.add(new ArrayList<>(subSet));
            return;
        }

        subsets(nums, results, subSet, i + 1);
        subSet.add(nums[i]);
        subsets(nums, results, subSet, i + 1);
        subSet.remove(subSet.size() - 1);
    }


    public static void main(String[] args) {
        //int[] a = {1, 2, 3};
        int[] a = {0};

        List<List<Integer>> res = subsets(a);

        for (List<Integer> subsetList : res) {
            for (Integer num : subsetList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
