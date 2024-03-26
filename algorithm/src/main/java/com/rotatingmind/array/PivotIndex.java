package com.rotatingmind.array;

import java.util.stream.IntStream;

public class PivotIndex {


    public static int pivotIndex(int[] nums) {
        int length = nums.length;
        int pivot = 0, left = 0, right = IntStream.of(nums).skip(1).sum();
        System.out.println("right " + right);
        for (;;) {
            if (left == right) return pivot;
            left += nums[pivot];
            if (++pivot >= length) break;
            right -= nums[pivot];
        }
        return -1;
    }

    //1, 7, 3, 6, 5, 6
    public int pivotIndex2(int[] nums) {
        int rightSum, leftSum = 0;

        rightSum = IntStream.of(nums).sum();

        if (rightSum == leftSum) return 0;

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (rightSum == leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }

   public int pivotIndex1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = sum(nums, 0, i);
            int rightSum = sum(nums, i+1, nums.length);

            if (leftSum == rightSum) {
                return i;
            }
        }
       return -1;
    }

    private int sum(int[] nums, int start, int end) {
        return IntStream.range(start, end)
                .map(index -> nums[index])
                .sum();
    }

    public static void main(String[] args) {
        PivotIndex index = new PivotIndex();
        int nums[] = {1, 7, 3, 6, 5, 6};
        // int nums[] = {1, 2, 3};
        // int nums[] = {2, 1, -1};
        //System.out.println(index.pivotIndex(nums));
        System.out.println(index.pivotIndex2(nums));
    }

}
