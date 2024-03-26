package com.rotatingmind.math.lcm;

/**
 * LCM of a & b always max(a, b) <= lcm <= a * b
 */
public class LCM {

    public static int lcm(int a, int b) {
        int lcm = 1;

        for (int i = Math.max(a, b); i < a * b; i++) {

            if (i % a == 0 && i % b == 0) {
                lcm  = i;
                break;
            }
        }
        return lcm;
    }

    /**
     * gcd(a, b) * lcm(a,b) = a * b
     *
     * lcm(a, b) =  (a * b) / gcd(a, b)
     *
     * @param a
     * @param b
     * @return
     *
     * Now you can calculate LCM of full array in same manner as GCD ([a0, a2, a3, .....an])
     *  lcm ([a0, a2, a3, .....an]) = lcm * a[i] / GCD(lcm, a[i])
     */
    public static int lcm1(int a, int b) {
        int lcm = 1;

        for (int i = Math.max(a, b); i < a * b; i++) {

            if (i % a == 0 && i % b == 0) {
                lcm  = i;
                break;
            }
        }
        return lcm;
    }

    public static void main(String[] args) {
        System.out.println(lcm(12, 18));
    }
}
