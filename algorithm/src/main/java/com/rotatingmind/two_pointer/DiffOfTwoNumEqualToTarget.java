package com.rotatingmind.two_pointer;

import java.util.Arrays;

public class DiffOfTwoNumEqualToTarget {

    public static int[] towNumDiff(int[] nums, int target) {
        int[] res = new int[2];
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len; j++) {

                if (i != j && nums[i] - nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }

            }
        }
        return res;
    }

    /**
     * n[i] - n[j] = diff
     * => n[j] = n[i] - diff
     *
     * @param nums
     * @return
     */
    public static int[] towNumDiffV1(int[] nums, int diff) {
        int[] res = new int[2];
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (diff >= 0) {
                int curr = nums[i];
                int num = diff + curr;
                int index = search(nums, num, i + 1);
                if (index >= 0) {
                    res[0] = i;
                    res[1] = index;
                    break;
                }
            } else {
                int curr = nums[i];
                int num = curr - diff;
                int index = search(nums, num, i + 1);
                if (index >= 0) {
                    res[0] = i;
                    res[1] = index;
                    break;
                }
            }
        }
        return res;
    }

    private static int search(int[] nums, int num, int start) {
        int low = start, high = nums.length, mid = -1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] == num) {
                return mid;
            } else if (num < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int[] towNumDiffWithTwoPointer(int[] nums, int diff) {
        int[] res = new int[2];
        int len = nums.length;
        int j = 0, i = 0;
        while (j < len) {
            int curr = nums[j] - nums[i];

            if (diff < curr) {
                i++;
                if (i == j) {
                    j++;
                }
            } else if (diff > curr) {
                j++;
            } else {
                res[0] = i;
                res[1] = j;
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int arr[] = {11, 2, 7, 4, 15};  // 2, 4, 7, 11, 15
        Arrays.sort(arr);
        int result[] = towNumDiffWithTwoPointer(arr, 4);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
