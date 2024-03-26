package com.rotatingmind.array;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    //{4,5,6,7,0,1,2}
    private void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int j = k;
        for(int i = 0; i < nums.length - k; i++) {
            temp[j] = nums[i];
            j++;
        }

        for(int i = 0; i < k; i++){
            temp[i] = nums[nums.length - 1 - i];
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }

    public int findMin(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        if (min == nums[0] && max == nums[nums.length - 1]) return min;

        int rotationCount = 0;

        while(min != nums[0] && max != nums[nums.length - 1]) {
            rotate(nums, 1);
            rotationCount++;
        }
        System.out.println(rotationCount);
        return nums[0];
    }

    public int findMinV1(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (min > nums[i]) {
                min = nums[i];
            }

            if (max < nums[i]) {
                max = nums[i];
            }
        }

        if (min == nums[0] && max == nums[nums.length - 1]) return min;

        int rotationCount = 1;

        while(min != nums[0] && max != nums[nums.length - 1]) {
            rotateByOne(nums);
            rotationCount++;
        }
        return nums[0];
    }

    public void rotateByOne(int[] a) {
        int n = a.length;
        int t = a[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            a[i+1] = a[i];
        }
        a[0] = t;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        int[] nums = {3,4,5,1,2};
        int[] nums1 = {4,5,6,7,0,1,2};
        int[] nums2 = {11,13,15,17};
        System.out.println(findMinimumInRotatedSortedArray.findMin(nums1));
    }
}
