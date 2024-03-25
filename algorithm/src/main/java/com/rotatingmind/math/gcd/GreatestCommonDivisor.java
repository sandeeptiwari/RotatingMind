package com.rotatingmind.math.gcd;

/**
 * GCD (a, b) = must be less or equals to  min (a, b)
 *
 */
public class GreatestCommonDivisor {

    public int gcd1(int a, int b) {
        int gcd = 1;
        int min = Math.min(a, b);

        for (int i = 1; i < min; i++) {

            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    /**
     * GCD (12 , 18)
     * v = 18/12 here q = 1 and rem = 6 since its not 0, we cant say 12 is gcd
     * we have to do next round of divisor with rem 6
     * v = 12/6 = 2 and rem = 0
     * mean 6 is GCD
     * @param a
     * @param b
     * @return
     */
    public static int gcd (int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (max % min != 0) {
            int temp = max;
            max = min;
            min = temp % min;
        }
        return min;
    }

    public static void main(String[] args) {
        int gcd = gcd(12, 18);
        System.out.println(gcd);
    }
}
