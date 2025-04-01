package com.rotatingmind.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoyerMooreAlgorithm {

    public int majorityElement(List<Integer> nums) {
        int count = 0;
        int candidate = -1;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }


    public static void main(String[] args) {
        BoyerMooreAlgorithm obj = new BoyerMooreAlgorithm();

        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 2, 2));

        System.out.println("Result " + obj.majorityElement(nums));

    }
}
