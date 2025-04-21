package com.rotatingmind.math;

import java.util.*;
import java.util.stream.LongStream;

public class FindTheCountOfGoodIntegers3272 {

    public long countGoodIntegers(int n, int k) {

        List<String> allNDigitsNumbers = generateNDigitsNum(n);

        long count = allNDigitsNumbers.stream()
                //.flatMap(nums -> allPermutation(nums).stream())
               // .filter(num -> isPalindrome(num) && num % k == 0)
                .count();

        return count;
    }

    private List<String> generateNDigitsNum(int num) {
        long start = (long)Math.pow(10, num);
        long end = (long)(Math.pow(10, num + 1));
        return LongStream.range(start, end)
                .mapToObj(FindTheCountOfGoodIntegers3272::toCharacterArray)
                .toList();
    }

    // Helper method to convert number to Character[]
    private static String toCharacterArray(long number) {
        /*return String.valueOf(number)
                .chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);*/
        return String.valueOf(number);
    }

    private List<List<Integer>> permute(List<Integer> prefix, Character[] num, List<List<Integer>> result) {

        return permute(prefix, num, result);
    }

    private List<List<Integer>> allPermutation(Character[] nums) {
        int n = nums.length;
        List<Integer> prefix = new ArrayList<>(n);
        List<List<Integer>> results = new ArrayList<>();

        return permute(prefix, nums, results);
    }

    private boolean isPalindrome(int num) {
        int temp = num;
        int newNum = 0;
        while (temp != 0) {
            int rem = temp % 10;
            newNum = newNum * 10 + rem;
            temp /= 10;
        }
        return num == newNum;
    }
}
