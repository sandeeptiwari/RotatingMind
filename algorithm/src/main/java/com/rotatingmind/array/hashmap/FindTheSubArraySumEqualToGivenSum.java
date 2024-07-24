package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement: Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.
 */
public class FindTheSubArraySumEqualToGivenSum {


    public static int findAllSubArraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        int cnt = 0; // Number of subarrays:

        for (int i = 0; i < n; i++) { // starting index i
            for (int j = i; j < n; j++) { // ending index j

                int sum = getSum(arr, i, j);

                if (sum == k) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static int getSum(int[] a, int i, int j) {
        int sum = 0;

        for (int k = i; k <= j; k++) {
            sum += a[k];
        }

        return sum;
    }


    public static int[] findSubArray(int[] a, int sum) {
        int res[] = new int[2];
        int len = a.length;
        int i = 0, j = 0;
        int currSum = a[i];

        while (j < len) {
            if (currSum < sum) {
                j++;
                if (j < len) {
                    currSum += a[j];
                }
            } else if (currSum > sum) {
                currSum -= a[i];
                i++;
                if (i > j) {
                    j++;
                    if (j < len) {
                        currSum = a[j];
                    }
                }
            } else {
                res[0] = i;
                res[1] = j;
                break;
            }
        }
        return res;
    }


    public static int numOfSubArrayEqualToGivenSum(int[] a, int target) {
        int ans = 0, sum = 0;
        int n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += a[i];
            int diff = sum - target;
            if (map.containsKey(diff)) {
                ans += map.get(diff);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    /**
     * 1. First, we will run a loop(say i) that will select every possible starting index of the subarray.
     * The possible starting indices can vary from index 0 to index n-1(n = array size).
     * <p>
     * 2. Inside the loop, we will run another loop(say j) that will signify the ending index as well as the current element
     * of the subarray. For every subarray starting from the index i, the possible ending index can vary from index i to n-1(n = size of the array).
     * <p>
     * 3. Inside loop j, we will add the current element to the sum of the previous subarray i.e. sum = sum + arr[j].
     * After calculating the sum, we will check if the sum is equal to the given k. If it is, we will increase the value of the count.
     * <p>
     * Intuition: If we carefully observe, we can notice that to get the sum of the current subarray we just need to
     * add the current element(i.e. arr[j]) to the sum of the previous subarray i.e. arr[i….j-1].
     * <p>
     * Assume previous subarray = arr[i……j-1]
     * current subarray = arr[i…..j]
     * Sum of arr[i….j] = (sum of arr[i….j-1]) + arr[j]
     */

    public static int findAllSubArraysWithGivenSumV1(int arr[], int k) {
        int n = arr.length; // size of the given array.
        int cnt = 0; // Number of subarrays:

        for (int i = 0; i < n; i++) { // starting index i
            int sum = 0;
            for (int j = i; j < n; j++) { // ending index j
                // calculate the sum of subarray [i...j]
                // sum of [i..j-1] + arr[j]
                sum += arr[j];

                // Increase the count if sum == k:
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }

    /**
     * In this approach, we are going to use the concept of the prefix sum to solve this problem. Here, the prefix sum of
     * a subarray ending at index i simply means the sum of all the elements of that subarray.
     * First, we will declare a map to store the prefix sums and their counts.
     * <p>
     * Then, we will set the value of 0 as 1 on the map.
     * Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
     * For each index i, we will do the following:
     * -> We will add the current element i.e. arr[i] to the prefix sum.
     * -> We will calculate the prefix sum i.e. x-k, for which we need the occurrence.
     * -> We will add the occurrence of the prefix sum x-k i.e. mpp[x-k] to our answer.
     * -> Then we will store the current prefix sum in the map increasing its occurrence by 1.
     */
    public static int findSubArrayOfGivenSum(int[] a, int sum) {
        int preSum = 0;
        int n = a.length;
        int cnt = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += a[i];

            // Calculate x-k:
            int remove = preSum - sum;

            // Add the number of subarrays to be removed:
            cnt += map.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int arr[] = {5, 3, 4, 6, 2};
        // findSubArrayOfGivenSum(arr, 15);
        //System.out.println(subArray[0]);
        //
        // System.out.println(subArray[1]);

        int[] a = {3, 1, 2, 4};
        int k = 6;

        //int allSubArraysWithGivenSum = findSubArrayOfGivenSum(a, k);
        //System.out.println("Sum :: " + allSubArraysWithGivenSum);

        System.out.println(findSubArrayOfGivenSum(a, k));
    }
}
