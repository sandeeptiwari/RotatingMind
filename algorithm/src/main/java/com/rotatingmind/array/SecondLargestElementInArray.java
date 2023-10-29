package com.rotatingmind.array;

public class SecondLargestElementInArray {

    public int secondLargestElementInArray(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalStateException("No second largest element found.");
        }

        return secondLargest;
    }

    public int secondLargestElementInArrayJava8(int[] nums) {
        return java.util.Arrays.stream(nums)
                .boxed()
                .sorted(java.util.Collections.reverseOrder())
                .distinct()
                .limit(2)
                .skip(1)
                .findFirst()
                .get();
    }
}
