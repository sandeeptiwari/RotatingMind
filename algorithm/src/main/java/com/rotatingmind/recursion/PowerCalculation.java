package com.rotatingmind.recursion;

/**

 */
public class PowerCalculation {


    private int pow(int n, int k) {
        if (k == 0) return 1;

        int x = pow(n, k/2);

        if (k/2 == 0) {
            return  x * x;
        } else {
            return x * x * n;
        }
    }

    private int pow1(int n, int k) {
        if (k == 0) return 1;

        int x = pow(n, k/3);

        if (k/3 == 0) {
            return  x * x * x;
        } else if (k/3 == 1) {
            return x * x * x * n;
        } else {
            return x * x * x * n * n;
        }
    }


    public static void main(String[] args) {

    }

}
