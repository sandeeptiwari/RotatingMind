package com.rotatingmind.array;

/**
 * Maximum Sum Path in Two Arrays
 * Given two sorted arrays, the arrays may have some common elements. Find the sum of the maximum sum path to reach
 * from the beginning of any array to the end of any of the two arrays. We can switch from one array to another array only at common elements.
 * <p>
 * Note: The common elements do not have to be at the same indexes.
 *
 * Time complexity: O(m+n). In every iteration of while loops, an element from either of the two arrays is processed.
 * There are total m + n elements. Therefore, the time complexity is O(m+n).
 * Auxiliary Space: O(1), Any extra space is not required, so the space complexity is constant.
 */
public class MaximumSumPathInTwoArrays {

    public static int maxPathSum(int[] ar1, int[] ar2, int m, int n) {

        int i = 0, j = 0;

        int sum1 = 0;
        int sum2 = 0;
        int ans = 0;

        while (i < n && j < m) {
            if (ar1[i] < ar2[j]) {
                sum1 += ar1[i];
                i++;
            } else if (ar1[i] > ar2[j]) {
                sum2 += ar2[j];
                j++;
            } else {
                ans += Math.max(sum1, sum2) + ar1[i];
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
            }
        }

        // Add remaining elements of ar1[]
        while (i < m) {
            sum1 += ar1[i++];
        }

        // Add remaining elements of ar2[]
        while (j < n) {
            sum2 += ar2[j++];
        }


        // Add maximum of two sums of remaining elements
        ans += Math.max(sum1, sum2);

        return ans;
    }

    public static void main(String[] args) {
        int ar1[] = { 2, 3, 7, 10, 12, 15, 30, 34 };

        int ar2[] = { 1, 5, 7, 8, 10, 15, 16, 19 };

        int m = ar1.length;

        int n = ar2.length;

        System.out.println("Maximum sum path is :" + maxPathSum(ar1, ar2, m, n));
    }
}
