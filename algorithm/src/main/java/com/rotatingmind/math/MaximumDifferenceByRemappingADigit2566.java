package com.rotatingmind.math;

import java.util.regex.Pattern;

/**
 * You are given an integer num. You know that Bob will sneakily remap one of the 10 possible digits (0 to 9) to another digit.
 *
 * Return the difference between the maximum and minimum values Bob can make by remapping exactly one digit in num.
 *
 * Notes:
 *
 * When Bob remaps a digit d1 to another digit d2, Bob replaces all occurrences of d1 in num with d2.
 * Bob can remap a digit to itself, in which case num does not change.
 * Bob can remap different digits for obtaining minimum and maximum values respectively.
 * The resulting number after remapping can contain leading zeroes.
 *
 * Example 1:
 *
 * Input: num = 11891
 * Output: 99009
 * Explanation:
 * To achieve the maximum value, Bob can remap the digit 1 to the digit 9 to yield 99899.
 * To achieve the minimum value, Bob can remap the digit 1 to the digit 0, yielding 890.
 * The difference between these two numbers is 99009.
 * Example 2:
 *
 * Input: num = 90
 * Output: 99
 * Explanation:
 * The maximum value that can be returned by the function is 99 (if 0 is replaced by 9) and the minimum value that can be returned by the function is 0 (if 9 is replaced by 0).
 * Thus, we return 99.
 *
 * Constraints:
 *
 * 1 <= num <= 108
 */
public class MaximumDifferenceByRemappingADigit2566 {

    public static int minMaxDifference(int num) {
        String nStr = String.valueOf(num);
        // For max: replace first digit that's not 9 with 9
        char digitToReplaceMax = '\0';
        for (char ch : nStr.toCharArray()) {
            if (ch != '9') {
                digitToReplaceMax = ch;
                break;
            }
        }
        String maxStr = (digitToReplaceMax == '\0') ? nStr : nStr.replace(digitToReplaceMax, '9');
        System.out.println("MaxStr " + maxStr);
        // For min: replace first digit that's not 0 or already the first digit
        char digitToReplaceMin = nStr.charAt(0);  // to avoid leading 0
        String minStr = nStr.replace(digitToReplaceMin, '0');

        int maxNum = Integer.parseInt(maxStr);
        int minNum = Integer.parseInt(minStr);

        return maxNum - minNum;
    }

    public static void main(String[] args) {
        System.out.println(minMaxDifference(11891));
    }
}
