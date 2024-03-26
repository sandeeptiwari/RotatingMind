package com.rotatingmind.math;

import java.util.*;
import java.util.stream.Stream;

public class AllPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> items: permute) {
            items.forEach(ele -> {
                System.out.println(ele + ", ");
            });
            System.out.println("================");
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> prefix = new ArrayList<>(n);

        List<Integer> numbers = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        List<List<Integer>> results = new ArrayList<>();
        allPermutation(prefix, numbers, results);

        return results;
    }

    public static void allPermutation(List<Integer> prefix, List<Integer> numbers, List<List<Integer>> results) {
        if (numbers.isEmpty()) {
            results.add(new ArrayList<>(prefix));
        } else {
            for (int i = 0; i < numbers.size(); i++) {
                Integer eleByIndex = numbers.get(i);
                prefix.add(eleByIndex);
                numbers.removeIf(ele -> Objects.equals(ele, eleByIndex));
                allPermutation(prefix, numbers, results);
                numbers.add(i, eleByIndex);
                prefix.remove(prefix.size() - 1);
            }
        }
    }
}
