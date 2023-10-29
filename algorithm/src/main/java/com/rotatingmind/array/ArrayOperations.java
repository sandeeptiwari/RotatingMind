package com.rotatingmind.array;

import java.util.Arrays;

public class ArrayOperations {

    public void reverseArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start]  = nums[end];
        nums[end] = temp;
    }

    public void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


    public void moveAllZeroRightInArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] == 0) {
                swap(nums, start, end);
                end--;
            } else {
                start++;
            }
        }
    }

    public void moveAllZeroRightInArrayInJava8(int[] nums) {
        int[] result = Arrays.stream(nums)
                .filter(i -> i != 0)
                .toArray();
        System.out.println(Arrays.toString(result));
    }


    public static void main(String[] args) {
        ArrayOperations arrayOperations = new ArrayOperations();
        int[] nums = {1, 2, 3, 4, 5};
        arrayOperations.reverseArray(nums);
        arrayOperations.printArray(nums);
    }




}
