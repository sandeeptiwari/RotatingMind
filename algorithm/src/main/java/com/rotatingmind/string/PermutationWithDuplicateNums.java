package com.rotatingmind.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithDuplicateNums {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permuteUnique(nums, 0, results);
        return results;
    }

    public static void permuteUnique(int[] nums, int i, List<List<Integer>> results) {
        if (i == nums.length) {
            List<Integer> l = Arrays.stream(nums).boxed().toList();
            results.add(new ArrayList(l));
        }
        int n = nums.length;

        int[] freq = new int[10];

        for (int j = i; j < nums.length; j++) {
            if (freq[nums[j]] > 0) {
                continue;
            }

            freq[nums[j]]++;

            swap(nums, i, j);
            permuteUnique(nums, i + 1, results);
            swap(nums, i, j);
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int [] nums = {1,1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        lists.forEach(l -> {l.forEach(ele -> {
            System.out.print(ele+", ");
        });
            System.out.println("\n");
        });
    }
}
