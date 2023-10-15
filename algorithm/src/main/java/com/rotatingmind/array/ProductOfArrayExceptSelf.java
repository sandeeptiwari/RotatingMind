package com.rotatingmind.array;

import java.util.Arrays;

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
    public int[] productExceptSelfV1 (int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;

        for (int i = 0; i < n - 1; i++) {
            ans[i] = curr;
            curr *= nums[i];
        }

        // a = [1, 1, 2, 6]
        //b =  [24, 12, 4, 1]
        // result = 24, 12, 8, 6
        curr = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = curr;
            curr *= nums[i];
        }


        return ans;
    }



    public static void main(String[] args) {
        int[] a= {1,2,3,4};
        Arrays.stream(productExceptSelf(a))
                .forEach(System.out::println);
    }
}
