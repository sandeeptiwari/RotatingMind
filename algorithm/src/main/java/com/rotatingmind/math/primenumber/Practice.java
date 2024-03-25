package com.rotatingmind.math.primenumber;

/**
 * either divisor be 1 or itself min
 *
 */
public class Practice {

    public boolean isPrime(int num) {

        int count = 0;

        for (int i = 1; i < num /2; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        count++;

        if (count == 2) {
            return true;
        }

        return false;
    }

    public static boolean isPrimeV1(int num) {

        boolean isPrime = true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }


    public static void printAllPrime(int num) {

        for (int i = 2; i < num; i++) {

            if (isPrimeV1(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        printAllPrime(20);
    }
}
