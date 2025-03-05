package com.rotatingmind.math;

public class CheckIfNumberIsASumOfPowersOfThree {

    /**
     * Observations:
     * Any number can be represented in ternary (base-3), just like numbers are represented in binary (base-2).
     * A number can be written as a sum of distinct powers of 3 if its base-3 representation contains only 0s and 1s.
     *
     * Example:
     *    12 in base-3 is 110 (1 X 3^2 + 1x3^1 + 0x3^0), so it's valid.
     *    21 in base-3 is 210, which means it contains a 2, so it's not valid.
     *
     * Time Complexity
     * O(log₃ n) because we repeatedly divide n by 3.
     * O(1) space since we use only a few integer variables.
     *
     * Step-by-Step Complexity Analysis
     * What happens in each iteration?
     *
     * We check n % 3 (constant time, O(1)).
     * We divide n by 3 (n /= 3), which reduces n by a factor of 3.
     * How many times does the loop run?
     *
     * The loop runs until n becomes 0.
     * At each step, n is divided by 3.
     * This means the number of iterations is equal to the number of times we can divide n by 3 before it becomes 0.
     *
     * Mathematically, this is log₃(n) (log base 3 of n).
     *
     * n, n/3, n/3^2....1
     * = n/3^k = 1 = k = log3(n)
     *
     */
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false; // If any digit is '2', return false
            n /= 3; // Reduce the number by dividing it by 3
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
