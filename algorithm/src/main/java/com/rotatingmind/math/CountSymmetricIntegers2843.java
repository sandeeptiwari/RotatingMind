package com.rotatingmind.math;

import java.util.stream.IntStream;

/**
 * You are given two positive integers low and high.
 *
 * An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.
 *
 * Return the number of symmetric integers in the range [low, high].
 *
 *
 *
 * Example 1:
 *
 * Input: low = 1, high = 100
 * Output: 9
 * Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.
 * Example 2:
 *
 * Input: low = 1200, high = 1230
 * Output: 4
 * Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.
 */
public class CountSymmetricIntegers2843 {

    public int countSymmetricIntegers(int low, int high) {
        if (low > high) return 0;

        long count = IntStream.range(low, high + 1)
                .boxed()
                .filter(num -> {
                    var numOfDigits = (int) Math.floor(Math.log10(num)) + 1;

                    if (numOfDigits % 2 != 0) return false;

                    var firstHalf = digitSum(num.toString().substring(0, (numOfDigits / 2)));
                    var secHalf = digitSum(num.toString().substring(numOfDigits / 2, numOfDigits));

                    return firstHalf == secHalf ;
                }).count();

        return (int) count;
    }

    public int digitSum(String p) {

        int sum = 0;
        for (int i = 0; i < p.length(); i++) {
            sum += Integer.parseInt("" + p.charAt(i));
        }
        p = "" + sum;
        return sum;
    }

    public int countSymmetricIntegersV1(int low, int high) {
        int c = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int len = s.length();
            if (len % 2 != 0) continue;
            int half = len / 2;
            int sum1 = 0;
            int sum2 = 0;

            for (int j = 0; j < half; j++) {
                sum1 += s.charAt(j);
                sum2 += s.charAt(half + j);
            }

            if (sum1 == sum2) {
                c++;
            }
        }

        return c;
    }

    public int countSymmetricIntegersV2(int low, int high) {
        int count = 0;
        for (int num = low; num <= high; num++) {
            int digits = numDigits(num);
            if (digits % 2 != 0) continue;

            int half = digits / 2;
            int firstHalfSum = 0, secondHalfSum = 0;
            int temp = num;

            for (int i = 0; i < digits; i++) {
                int digit = temp % 10;
                if (i < half) secondHalfSum += digit;
                else firstHalfSum += digit;
                temp /= 10;
            }

            if (firstHalfSum == secondHalfSum) count++;
        }
        return count;
    }

    private int numDigits(int num) {
        if (num == 0) return 1;
        return (int) Math.log10(num) + 1;
    }

    public int countSymmetricIntegersV3(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            String num = String.valueOf(i);
            int digits = num.length();
            if (digits % 2 != 0) continue;

            int firstHalfSum = 0;
            int secondHalfSum = 0;
            int half = digits / 2;

            for (int j = 0; j < half; j++) {
                firstHalfSum  += num.charAt(j);
                secondHalfSum += num.charAt(half + j);
            }

            if (firstHalfSum == secondHalfSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountSymmetricIntegers2843 c = new CountSymmetricIntegers2843();
        System.out.println(c.countSymmetricIntegers(1, 100));
        System.out.println(c.countSymmetricIntegers(1200, 1230));
        System.out.println(c.countSymmetricIntegers(11, 11));
    }
}
