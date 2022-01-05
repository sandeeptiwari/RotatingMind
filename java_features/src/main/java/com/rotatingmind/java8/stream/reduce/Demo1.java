package com.rotatingmind.java8.stream.reduce;

import java.util.Arrays;

public class Demo1 {

    public static void main(String[] args) {
        example1();
    }

    public static void example1() {
        Integer[] nums = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        Integer sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);

        Integer sum1 = Arrays.stream(nums).reduce(0, Integer::sum);

        System.out.println("Sum " + sum);
    }

    public static void example2() {
        Integer[] nums = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        Integer sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        System.out.println("Sum " + sum);
    }
}
