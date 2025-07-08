package com.rotatingmind.math;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountLargestGroup1399 {
    public int countLargestGroup(int n) {
        // Step 1: Group numbers from 1 to n by their digit sum
        Map<Integer, List<Integer>> grouped = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.groupingBy(this::digitSum));

        // Step 2: Count how many numbers are in each group (i.e., their sizes)
        Collection<Integer> groupSizes = grouped.values().stream()
                .map(List::size)
                .toList();

        // Step 3: Find the maximum size
        int maxSize = groupSizes.stream().max(Integer::compare).orElse(0);

        // Step 4: Count how many groups have that maximum size
        long count = groupSizes.stream().filter(size -> size == maxSize).count();

        return (int) count;
    }

    public int countLargestGroupV1(int n) {
        int[] groupSizes = new int[37];
        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
           int sum  = digitSum(i);
           groupSizes[sum]++;

           maxSize = Math.max(groupSizes[sum], maxSize);
        }

        int count = 0;
        for (int size : groupSizes) {
            if (size == maxSize) {
                count++;
            }
        }

        return count;
    }

    public int countLargestGroupV2(int n) {
        Map<Integer, Integer> groupBySizes = new HashMap<>();
        int maxSize = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int sum  = digitSum(i);
            groupBySizes.compute(sum, (k, v) -> v == null ? 1 : v + 1);
            int size = groupBySizes.getOrDefault(sum, 0);
            if (size == maxSize) {
                count++;
            } else if (size > maxSize) {
                maxSize = size;
                count = 1;
            }
        }
        return count;
    }

    public int digitSum(int num) {
        int sum = 0;

        while(num > 0) {

            sum += num % 10;

            num = num / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        CountLargestGroup1399 c = new CountLargestGroup1399();
        System.out.println(c.countLargestGroupV2(2));
    }
}
