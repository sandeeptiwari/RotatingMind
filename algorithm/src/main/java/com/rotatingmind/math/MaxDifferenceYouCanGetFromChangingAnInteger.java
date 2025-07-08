package com.rotatingmind.math;

/**
 * You are given an integer num. You will apply the following steps to num two separate times:
 *
 * Pick a digit x (0 <= x <= 9).
 * Pick another digit y (0 <= y <= 9). Note y can be equal to x.
 * Replace all the occurrences of x in the decimal representation of num by y.
 * Let a and b be the two results from applying the operation to num independently.
 *
 * Return the max difference between a and b.
 *
 * Note that neither a nor b may have any leading zeros, and must not be 0.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 555
 * Output: 888
 * Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
 * The second time pick x = 5 and y = 1 and store the new integer in b.
 * We have now a = 999 and b = 111 and max difference = 888
 * Example 2:
 *
 * Input: num = 9
 * Output: 8
 * Explanation: The first time pick x = 9 and y = 9 and store the new integer in a.
 * The second time pick x = 9 and y = 1 and store the new integer in b.
 * We have now a = 9 and b = 1 and max difference = 8
 */
public class MaxDifferenceYouCanGetFromChangingAnInteger {

    public int maxDiff(int num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        char digitToReplaceMax = '\0';

        for (char ch : numStr.toCharArray()) {
           if (ch != '9') {
               digitToReplaceMax = ch;
               break;
           }
        }

        String maxStr = digitToReplaceMax != '0' ? numStr.replace(digitToReplaceMax, '9') : numStr;
        int maxNum = Integer.parseInt(maxStr);

        String minStr = "";
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if (i == 0) {
                if (ch != '1') {
                    minStr = numStr.replace(ch, '1');
                    break;
                }
            } else if (ch != '0' && ch != numStr.charAt(0)){
                minStr = numStr.replace(ch, '0');
                break;
            }
        }

        int minNum = Integer.parseInt(minStr);

        return maxNum - minNum;
    }

    public static void main(String[] args) {
        MaxDifferenceYouCanGetFromChangingAnInteger solver = new MaxDifferenceYouCanGetFromChangingAnInteger();

        int[] testCases = {
                11891,      // Example
                1234,       // Basic increasing
                1111,       // All digits same
                9999,       // Already max
                1000,       // Starts with 1, has zeros
                908172,     // Mixed
                876543,     // Decreasing
                219,        // Short number
                1,          // Single digit
                10,         // Two-digit
                907,        // High/low mix
                8001,       // Leading high
                1991,       // 1 at start, 9s later
                290,        // Starting with 2
                777,        // All same digit < 9
                999,        // All 9s
                909090,     // Alternating 9 and 0
                101,        // Palindromic
                312,        // Random
                4506,        // Mixed
                555,
                9
        };

        for (int num : testCases) {
            int result = solver.maxDiff(num);
            System.out.printf("maxDiff(%d) = %d%n", num, result);
        }
    }
}
