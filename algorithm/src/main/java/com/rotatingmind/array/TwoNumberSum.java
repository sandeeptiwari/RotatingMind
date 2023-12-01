package com.rotatingmind.array;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

    public static int[] twoSum(int[] nums, int target) {
        int[][] searchTable = {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}};
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int toSearch = target - nums[i];
            if (toSearch >= 0) {
                if (searchTable[toSearch][0] == -1) {
                    searchTable[toSearch][0] = i;
                } else if (searchTable[toSearch][0] != -1 && searchTable[toSearch][1] == -1) {
                    searchTable[toSearch][1] = i;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int toSearch = target - nums[i];
            if (toSearch >= 0) {
                if (searchTable[toSearch][0] != -1 && searchTable[toSearch][1] != -1) {
                    result[0] = searchTable[toSearch][0];
                    result[1] = searchTable[toSearch][1];
                    break;
                } else if (nums[i] !=  toSearch && searchTable[nums[i]][0] != -1 && searchTable[toSearch][0] != -1) {
                    result[0] = searchTable[nums[i]][0];
                    result[1] = searchTable[toSearch][0];
                    break;
                }
            }
        }
        return result;
    }

    public static int[] twoSumV1(int[] nums, int target) {
        Map<Integer, Integer> numberByIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numberByIndex.containsKey(complement)) {
                return new int[]{numberByIndex.get(complement), i};
            }

            numberByIndex.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution found");
    }



    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int target1 = 9;

        int[] nums2 = {3, 2, 4};
        int target2 = 6;

        int[] nums = {3, 3};
        int target = 6;

        int[] nums3 = {2, 5, 5, 11};
        int target3 = 10;

        int[] nums4 = {0, 4, 3, 0};
        int target4 = 0;

        int[] nums5 = {-3,4,3,90};
        int target5 = 0;

        int[] nums6 = {-1,-2,-3,-4,-5};
        int target6 = -8;

        int[] nums7 = {2,4,11,3};
        int target7 = 6;



        int[] results = twoSumV1(nums1, target1);
        System.out.println("Sum at " + results[0] + " And " + results[1]);
    }
}
