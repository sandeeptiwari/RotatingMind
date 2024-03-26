package com.rotatingmind.array;

import java.util.*;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 */
public class ThreeSumInArray {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> results = new ArrayList<>();

        if (len < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int num1 = nums[i];
            int target = -num1;

            List<List<Integer>> trippletes = twoSum(nums, target, i + 1, len - 1);
            if (!trippletes.isEmpty()) {
                results.addAll(trippletes);
            }
        }
        return results;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start, int end) {
        List<List<Integer>> results = new ArrayList<>();

        while (start < end) {
            List<Integer> tripltes = new ArrayList<>();

            if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }
                tripltes.add(-target);
                tripltes.add(nums[start]);
                tripltes.add(nums[end]);
                results.add(tripltes);

                start++;
                end--;
            }
        }
        return results.isEmpty() ? Collections.emptyList() : results;
    }

    public static void main(String[] args) {
        ThreeSumInArray obj = new ThreeSumInArray();
        int[] nums = {-1, 0, 1, 2, -1, -4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] nums2 = {-1, 0, 1, 2, -1, -4}; // [-4, -1, -1, 0, 1, 2]
        int[] nums3 = {0, 0, 0, 0};
        int[] nums4 = {-2, 0, 0, 2, 2};
        int[] nums5 = {-2, 0, 1, 1, 2};
        int[] nums6 = {-2, 0, 0, 2, 2};
        int[] nums7 = {-5, 0, 1, 1, 2, 3, 3, 4, 4};

        List<List<Integer>> lists = obj.threeSum(nums7);
        lists.forEach(System.out::println);
    }
}
