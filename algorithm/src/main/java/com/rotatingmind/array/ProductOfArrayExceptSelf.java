package com.rotatingmind.array;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * Constraints:
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space
 * for space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];
        int j = 0, product = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < nums.length; k++) {
                if (k != i) {
                    product *= nums[k];
                }
            }
            answers[j] = product;
            product = 1;
            j++;
        }

        return answers;
    }


    //Input: nums = [1,2,3,4]
    public static int[] productExceptSelfV1 (int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;

        for (int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        System.out.println(ans);
        // a = [1, 1, 2, 6]
        //b =  [24, 12, 8, 6]
        // result = 24, 12, 8, 6
        curr = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        System.out.println(ans);

        return ans;
    }


    //Input: nums = [1,2,3,4]
    public static int[] productExceptSelfV2(int[] nums) {
        int len = nums.length;
        int[] result = new int[nums.length];
        int[] prefixProductStart = new int[nums.length];
        int[] prefixProductEnd = new int[nums.length];

        prefixProductStart[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefixProductStart[i] = prefixProductStart[i - 1] * nums[i];
        }

        prefixProductEnd[len - 1] =  nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            prefixProductEnd[i] = prefixProductEnd[i + 1] * nums[i];
        }

        // a = 1, 2, 6, 24
        // b = 24, 24, 12, 4
        //res = 24, 12, 8, 6
        result[0] =  prefixProductEnd[0];
        result[len - 1] = prefixProductStart[len - 2];
        for (int i = 1; i < len - 1; i++) {
              result[i] = prefixProductStart[i - 1] * prefixProductEnd[i + 1];
        }

        return result;
    }





    public static void main(String[] args) {
        int[] a= {1,2,3,4};
        Arrays.stream(productExceptSelfV2(a))
                .forEach(ele -> System.out.print(" " + ele));
    }
}
