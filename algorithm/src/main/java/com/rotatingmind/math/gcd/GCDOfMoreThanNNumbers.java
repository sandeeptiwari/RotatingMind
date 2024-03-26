package com.rotatingmind.math.gcd;

/**
 * If you have to calculate GCD of more than 2 numbers then pick any 2 numbers
 * calculate GCD(a0, a1) and then alter 2 number as one number
 * GCD(a, b, c) = (GCD(a,b), c) = GCD(x, c)
 */
public class GCDOfMoreThanNNumbers {

    public static int gcd(int[] a) {
        int n = a.length;
        int gcd = calculateGCD(a[0], a[1]);
        for (int i = 2; i < n; i++) {
            gcd = calculateGCD(gcd, a[i]);
        }
        return gcd;
    }

    private static int calculateGCD(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        while (max % min != 0) {
            int temp = max;
            max = min;
            min = temp % min;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 12, 18, 24};
        System.out.println(gcd(a));
    }


}
