package com.rotatingmind.string;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * Given n and k, return the kth permutation sequence.
 *
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 * Example 3:
 * Input: n = 3, k = 1
 * Output: "123"
 */
public class PermutationSequence {
    public static String finalAns = null;
    public static int count = 1;

    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        getPermutation(nums, 0, k);
        return finalAns;

    }

    public static void getPermutation(int[] nums, int i, int k) {

        if(i == nums.length && count == k) {
            StringBuilder sb = new StringBuilder();
            for(int index : nums) {
                sb.append(index);
            }
            finalAns  = sb.toString();
            count++;
            return;
        }

        if(i == nums.length) {
            count++;
            return;
        }
        for (int j = i; j < nums.length; j++) {
            rightRotate(nums, i, j);
            getPermutation(nums, i + 1, k);
            leftRotate(nums, i, j);
        }

    }

    public static void rightRotate(int[] nums, int index, int j) {
        int temp = nums[j];
        for(int k = j; k > index ; k--) {
            nums[k] = nums[k-1];
        }
        nums[index] = temp;
    }

    public static void leftRotate(int[] nums, int index, int j) {
        int temp = nums[index];
        for(int k = index; k < j ; k++) {
            nums[k] = nums[k+1];
        }
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(getPermutation(3, 3));
    }

}
