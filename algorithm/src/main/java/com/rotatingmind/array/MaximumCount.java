package com.rotatingmind.array;

public class MaximumCount {
    public int maximumCount1(int[] nums) {
        int n = nums.length;
        int neg = 0, pos = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] < 0) {
                neg++;
            } else if (nums[i] > 0) {
                pos++;
            }
        }

        return Math.max(neg, pos);

    }

    public int maximumCount(int[] nums) {
        int n = nums.length;

        // First non-negative index (first element >= 0)
        int firstNonNegative = lowerBound(nums, 0);

        // First positive index (first element > 0)
        int firstPositive = lowerBound(nums, 1);

        // Calculate counts
        int neg = firstNonNegative;  // All elements before first non-negative are negative
        int pos = n - firstPositive; // All elements after first positive are positive

        return Math.max(neg, pos);
    }

    // Binary Search for Lower Bound (first element >= target)
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MaximumCount solution = new MaximumCount();
        int[] nums = {-5, -3, -1, 0, 2, 4, 6};  // Example sorted array
        int[] nums1 = {-2,-1,-1,1,2,3};  // Example sorted array
        System.out.println("Maximum Count: " + solution.maximumCount(nums1));  // Output: 3
    }
}
