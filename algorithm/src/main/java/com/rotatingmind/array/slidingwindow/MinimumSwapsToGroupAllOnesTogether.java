package com.rotatingmind.array.slidingwindow;

/**
 * Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.
 *
 * Example 1:
 *
 * Input: data = [1,0,1,0,1]
 * Output: 1
 * Explanation: There are 3 ways to group all 1's together: [1,1,1,0,0] using 1 swap. [0,1,1,1,0] using 2 swaps. [0,0,1,1,1] using 1 swap. The minimum is 1.
 *
 * Example 2:
 *
 * Input: data = [0,0,0,1,0]
 * Output: 0
 * Explanation: Since there is only one 1 in the array, no swaps are needed.
 *
 * Example 3:
 *
 * Input: data = [1,0,1,0,1,0,0,1,1,0,1]
 * Output: 3
 * Explanation: One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
 *
 * Constraints:
 *
 * 1 <= data.length <= 105
 * data[i] is either 0 or 1.
 *
 *
 *
 * Solution
 * This is a classic sliding window question that has a fixed size. We wish to find a window to store all the 1's in
 * the very end, thus we fix the size to the total number of 1's. Since we want to use minimum number of swaps,
 * it will be best if we can find a window with most 1's (or least 0's). Let count1 be the number of 1's in the entire data.
 * We will initialize total to be the number of 1's in the window from index 0 to the count1 (which is the sum of the window).
 * Then, as we slide the window to the right, we remove data[r-count1] from the total and add data[r] to the total so that total
 * is the sum of the new window. Then for each window that has size of count1, we compare for the minimum swaps.
 * ere, we calcluate the swaps count1-total, as the number of swaps is just the number of 0's in the window.
 */
public class MinimumSwapsToGroupAllOnesTogether {

    public static void main(String[] args) {
        int [] a = {0,1,0,1,1,0,0};

        System.out.println(minSwaps(a));
    }

    public static int minSwaps(int[] nums) {

        int n = nums.length;
        int zeroCount = 0 ;
        int totalOne = 0; // windowSize
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                totalOne++;
            }
        }

        if (n == totalOne || totalOne == 0)
            return 0;

        for (int i = 0; i < totalOne; i++) {
            if( nums[i % n] == 0){
                zeroCount++;
            }
        }

        for( int i = totalOne ; i < 2 * n; i++) {
            if( nums[i % n] == 0){
                zeroCount++;
            }
            if( nums[(i  - totalOne) % n ] == 0){
                zeroCount--;
            }
            min = Math.min(min, zeroCount);
        }

        return min;
    }
}
