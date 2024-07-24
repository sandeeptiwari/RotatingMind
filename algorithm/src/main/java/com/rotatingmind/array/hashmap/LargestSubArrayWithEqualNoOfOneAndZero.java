package com.rotatingmind.array.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 */
public class LargestSubArrayWithEqualNoOfOneAndZero {

    /**
     * Approach:
     *
     * Use two nested loops.
     * Take variable sum = 0, at its start, in which we will take our cumulative sum from all the sub-arrays.
     * The outer loop picks a starting point i = 0 and the inner loop will start from j = i + 1.
     * Start taking the sum from all the subarrays, whenever we get sum value = 0, it means it has an equal number of 1s and 0s.
     * Now compare every size with the longest subarray(maxlen variable), if we got the max size than the longest subarray we will update our subarray in the maxlen variable.
     * Return the longest subarray maxlen startIndex and Size.
     * @param nums
     * @param n
     *
     * // 1, 0, 0, 1, 0, 0, 1, 1, 0
     */
    static void findSubArray(int nums[], int n) {
        int sum = 0;
        int maxlen = -1, startindex, len = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] == 0) ? -1 : 1;
        }
        // Pick a starting point as i

        for (int i = 0; i < n; i++) {
            // Consider all subarrays starting from i
            sum = 0;
            len = 0;
            for (int j = 0; j < n; j++) {
                 sum += nums[j];
                 len++;
                // If this is a 0 sum subarray, then
                // compare it with maximum size subarray

                if (sum == 0 && maxlen < len) {
                    maxlen = len;
                    startindex = i;
                    len = 0;
                }
            }
        }

        if (maxlen == -1)
            System.out.println("No such subarray");
        else
            System.out.println("The length of the longest subarray is: " + maxlen);
    }

    /**
     * Approach:
     *
     * Convert all the "0" to "-1" in the example, so that we get something like :-
     *  [0, 0,1,0,1,0] -> [-1, -1, 1, -1, 1, -1]. If you see this, the problem is somewhat like returning the longest subarray length whose sum is "ZERO".
     *
     * As the question is telling us to return same/equal numbers of zeros and ones.
     * So, that means the same as well there will be equal no. of 1 & -1 .
     *  sum  1 + (-1) = 0,we conclude that we need to return that subarray length, whose sum is 0 with the longest subarray.
     *
     *
     *  At start max = 0 and so index will be -1 and cumulative sum = 0.
     * We move further to get a max of 1. And in our hashmap for reference we put the key 0 -> -1 value.
     * We will check in our key value pair if we have the pair of 1? As at index 0 ->0
     * No there is no pair of 1 we will move forward by adding sum = -1 and -1(at 1st index) = sum = -1+ -1 = -2
     * Move forward and check the index(2) we got 1 that means sum = -2 + 1 = -1.
     * Since we already have -1 in our map, that means there is a subarray and length = 2 (index(2) - index(0))  ,subarray = [0,1]
     * Now moving further & at index 3 we got a gain of 1 as Our cumulative sum is  = -1 + -1 = -2 And if we look at hashmap -2 is already present there is a subarray, length index(3-2) = 1 will not update the length here 1 < 2,
     * At index 4 we have 1 so sum = -2 + 1 = -1 and  -1 is already in the hashmap at index 1 and 0 length from 0 to 4 = index(4 - 0) = 4 another one is index(4 - 3) = 1 max-length = 4
     * Finally, our max-length = 4.
     */


    public static void largestSubArray(int[] a) {
        int n = a.length;
        int start = -1;
        int end = -1;
        int maxLen = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // at the starting we will put -1 for 0

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                sum += -1; //whenever we have 0 = -1
            } else if (a[i] == 1) {
                sum += +1; // whenever we have 1 = 1
            }

            if (map.containsKey(sum)) {
                int idx = map.get(sum);
                int len = i - idx;
                if (len > maxLen) {
                    start = idx + 1;
                    end = i;
                    maxLen = len;
                }
            } else {
                map.put(sum, i);
            }


        }
        System.out.println("Start " + start + " End " + end);

    }

    public static void main(String[] args) {
        //int[] a = { 1, 1, 0, 1, 1, 0, 0 };
       // largestSubArray(a);


        int arr[] = { 1, 0, 0, 1, 0, 0, 1, 1, 0 };
        int size = arr.length;
        findSubArray(arr, 7);
    }
}
