package com.rotatingmind.math;

public class PowerOfNumber {

    public static void main(String[] args) {
        PowerOfNumber obj = new PowerOfNumber();
        // System.out.println(obj.powV(3, 4));

        System.out.println(obj.powV1(4, 2));
    }


    public int pow(int x, int n) {

        int res = 1;

        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }

    public int powV1(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * powV1(x, n - 1);
    }

    public int powV(int x, int n) {

        if (n == 0) return 1;

        if ((n  & 1) == 0) {
            return powV(x, n >> 1) * powV(x, n >> 1);
        } else {
            return powV(x, n - 1) * x;
        }

    }

    public int iterativePower(int x, int n) {
        int result = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                result = result * x;
            }
            n = n >> 1;
            x = x*x;
        }
        return result;
    }
}
