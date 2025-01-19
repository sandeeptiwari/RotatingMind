package com.rotatingmind.math;

/**
 * Signed 32-bit Integer Range:
 * A signed 32-bit integer has a range of [-2³¹, 2³¹ - 1] (i.e., [-2147483648, 2147483647]).
 *
 * If reversing the integer results in a value outside this range, the function should return 0.
 * Key Constraints:
 *
 * We cannot store or manipulate the number as a 64-bit integer (e.g., long in Java), which means we need to handle
 * overflow carefully.
 *
 * Critical Edge Cases:
 *
 * Positive and negative numbers.
 * Numbers that end in zero (e.g., 120 should become 21).
 * Reversing causes overflow (e.g., reversing 2147483647 results in overflow).
 *
 *
 *
 * Revised Approach:
 *
 * To fix your current solution and handle overflow, we’ll follow these steps:
 *
 * Extract Digits Using Modulo Operation:
 *
 * Extract the last digit using x % 10.
 * Remove the last digit using x = x / 10.
 * Rebuild the Reversed Number:
 *
 * Multiply the current reversed number (n) by 10 and add the extracted digit.
 * Handle Overflow:
 *
 * Before multiplying n by 10, check if the result would overflow.
 * Since n is still 32-bit, the key is to compare it against INT_MAX / 10 and INT_MIN / 10
 * to detect overflow before it happens.
 *
 * Return Result or Handle Overflow Case:
 *
 * If an overflow is detected, return 0.
 *
 * Explanation:
 * Extract Last Digit:
 *
 * rem = x % 10 extracts the last digit of x.
 * Example: For x = 123, rem = 3.
 * Handle Overflow Before Updating n:
 *
 * Positive Overflow:
 * n > Integer.MAX_VALUE / 10: If n is already larger than 214748364, multiplying it by 10 would cause overflow.
 * n == Integer.MAX_VALUE / 10 && rem > 7: If n is exactly 214748364, adding any digit greater than 7 would exceed 2147483647.
 * Negative Overflow:
 * n < Integer.MIN_VALUE / 10: If n is less than -214748364, multiplying it by 10 would cause overflow.
 * n == Integer.MIN_VALUE / 10 && rem < -8: If n is exactly -214748364, adding any digit smaller than -8 would exceed -2147483648.
 * Update the Reversed Number:
 *
 * Multiply the current reversed number by 10 and add the extracted digit:
 * n = n * 10 + rem.
 * Remove the Last Digit:
 *
 * Remove the last digit of x using x = x / 10.
 * Repeat Until x == 0:
 *
 * Continue extracting and reversing digits until x becomes 0.
 * Return the Reversed Number:
 *
 * If no overflow occurs, return n.
 *
 * Complexity:
 * Time Complexity:
 * 𝑂(log10x): Each digit of x is processed once.
 * Space Complexity:𝑂(1)
 * O(1): No extra data structures are used.
 *
 */
public class ReverseTheNumber {

    public int reverse(int x) {
        int n = 0; // Variable to store the reversed number

        while (x != 0) {
            // Extract the last digit
            int rem = x % 10;

            // Check for overflow before updating `n`
            if (n > Integer.MAX_VALUE / 10 || (n == Integer.MAX_VALUE / 10 && rem > 7)) {
                return 0; // Positive overflow
            }
            if (n < Integer.MIN_VALUE / 10 || (n == Integer.MIN_VALUE / 10 && rem < -8)) {
                return 0; // Negative overflow
            }

            // Update the reversed number
            n = n * 10 + rem;

            // Remove the last digit from `x`
            x = x / 10;
        }

        return n;
    }

}
