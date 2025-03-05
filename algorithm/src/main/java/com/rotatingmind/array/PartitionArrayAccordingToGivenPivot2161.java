package com.rotatingmind.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayAccordingToGivenPivot2161 {

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> leftPartition = new ArrayList<>();
        List<Integer> rightPartition = new ArrayList<>();
        int pivotCounts = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) {
                pivotCounts++;
            } else if (nums[i] < pivot) {
                leftPartition.add(nums[i]);
            } else {
                rightPartition.add(nums[i]);
            }
        }

        List<Integer> result = leftPartition;

        for (int i = 0; i < pivotCounts; i++) {
            result.add(pivot);
        }

        result.addAll(rightPartition);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] pivotArrayV1(int[] nums, int pivot) {
        int leftCount = 0, pivotCount = 0, rightCount = 0;

        // First pass: Count elements
        for (int num : nums) {
            if (num < pivot) leftCount++;
            else if (num == pivot) pivotCount++;
            else rightCount++;
        }

        // Allocate result array
        int[] result = new int[nums.length];
        int leftIndex = 0, pivotIndex = leftCount, rightIndex = leftCount + pivotCount;

        // Second pass: Populate result array
        for (int num : nums) {
            if (num < pivot) result[leftIndex++] = num;
            else if (num == pivot) result[pivotIndex++] = num;
            else result[rightIndex++] = num;
        }

        return result;
    }



    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;
        //Output: [9,5,3,10,10,12,14]

        PartitionArrayAccordingToGivenPivot2161 obj = new PartitionArrayAccordingToGivenPivot2161();
        int[] res = obj.pivotArrayV1(nums, pivot);

        Arrays.stream(res).boxed().forEach(System.out::println);
    }

}
