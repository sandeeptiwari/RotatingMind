package com.rotatingmind.array.hashmap;

import com.rotatingmind.array.CheckDuplicacyInArray;

import java.util.*;

/**
 * You are given an integer array nums. You need to ensure that the elements in the array are distinct. To achieve this,
 * you can perform the following operation any number of times:
 *
 * Remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove all remaining elements.
 * Note that an empty array is considered to have distinct elements. Return the minimum number of operations needed to make the elements
 * in the array distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,2,3,3,5,7]
 *
 * Output: 2
 *
 * Explanation:
 *
 * In the first operation, the first 3 elements are removed, resulting in the array [4, 2, 3, 3, 5, 7].
 * In the second operation, the next 3 elements are removed, resulting in the array [3, 5, 7], which has distinct elements.
 * Therefore, the answer is 2.
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,4,4]
 *
 * Output: 2
 *
 * Explanation:
 *
 * In the first operation, the first 3 elements are removed, resulting in the array [4, 4].
 * In the second operation, all remaining elements are removed, resulting in an empty array.
 * Therefore, the answer is 2.
 *
 * Example 3:
 *
 * Input: nums = [6,7,8,9]
 *
 * Output: 0
 *
 * Explanation:
 *
 * The array already contains distinct elements. Therefore, the answer is 0.
 */
public class LeetCode3396 {

    public int minimumOperations(int[] nums) {
        if (nums.length == 0) return 0;

        List<Integer> tempList = new ArrayList<>(Arrays.stream(nums).boxed().toList());

        int count = 0;

        if (!hasDuplicates(tempList)) return count;


        while (!tempList.isEmpty() && hasDuplicates(tempList)) {

            if (tempList.size() < 3) {
                tempList.clear();
            } else {
                tempList = tempList.subList(3, tempList.size());
            }

            count++;
        }

        return count;
    }

    private boolean hasDuplicates(List<Integer> nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            if (!numSet.add(nums.get(i))) {
                return true;
            }
        }
        return false;
    }

    public int minimumOperations1(int[] nums) {
        int count = 0;
        int start = 0;
        int n = nums.length;

        while (start < n) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;

            for (int i = start; i < n; i++) {
                if (!seen.add(nums[i])) {
                    hasDuplicate = true;
                    break;
                }
            }

            if (!hasDuplicate) break;

            count++;
            start = Math.min(start + 3, n); // remove 3 elements logically
        }

        return count;
    }

    /**
     * This means that from index i to the end there is a duplicate.
     *
     * So we need to remove everything up to index i, which is i + 1 elements.
     *
     * Since we remove 3 at a time, the number of operations needed is (i / 3 + 1).
     * @param nums
     * @return
     */
    public int minimumOperations2(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[101];
        for(int i = n - 1 ; i >= 0 ; i--){
            if(seen[nums[i]])
                return i / 3 + 1;
            else seen[nums[i]] = true;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,2,3,3,5,7};
        LeetCode3396 obj = new LeetCode3396();
        System.out.println("Result :: " + obj.minimumOperations2(a));
    }
}
