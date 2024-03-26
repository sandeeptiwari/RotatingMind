package com.rotatingmind.two_pointer;

import java.util.Arrays;

public class FindTargetSumFromTwoNums {

    public static int[] findTowSum(int[] nums, int target) {
         int len = nums.length;
          int[] result = new int[2];
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;

                break;
            }
        }

        return result;
    }

    public static int findTowSumUsingBinary(int[] nums, int val, int start) {
        int len = nums.length;
        int low = start;
        int high = len - 1;
        int mid = - 1;
        while(low <= high) {
            mid = (low + high) / 2;

            if (val == nums[mid]) {
                return mid;
            } else if (nums[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


    //a = {1, 4,4,5,5,5,6,6,11}, k = 10
    public static int[] findTwoSumInSortedArray(int[] arr, int target) {
        int[] res = new int[2];

        for (int i = 0, j = arr.length - 1; i < j; ) {

            if (arr[i] + arr[j] == target) {
                res[0] = i;
                res[1] = j;
                break;
            } else if (arr[i] + arr[j] < target) {
                i++;
            } else if (arr[i] + arr[j] > target) {
                j--;
            }

        }
        return res;
    }

    //o(n)
    public int[] findTwoSumInSortedArrayV1(int[] arr, int target) {
        int[] res = new int[2];

        for (int i = 0, j = arr.length - 1; i < j; ) {

            if (arr[i] + arr[j] == target) {
                res[0] = i;
                res[1] = j;
                break;
            } else if (arr[i] + arr[j] < target) {
                i++;
            } else if (arr[i] + arr[j] > target) {
                j--;
            }

        }
        return res;
    }

    /*public static void main(String[] args) {
        int[] arr = {2, -1, 0, 3, 9};

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int complement = 8 - arr[i];
            int result = findTowSumUsingBinary(arr, complement, i + 1);

            if (result >= 0) {
                System.out.println(" Num1 " + arr[i] + " Num2 " + arr[result]);
            }
        }
    }*/

    public static void main(String[] args) {
        int[] arr = {1, 4, 4, 5, 5, 5, 6, 6, 11};
        int[] res = findTwoSumInSortedArray(arr, 10);

        System.out.println("Sum of " + arr[res[0]] + " And " + arr[res[1]] + " = " + (arr[res[0]] + arr[res[1]]));
    }
}
