package com.rotatingmind.math;

import java.util.Arrays;

public class PrimeNumber {

    public static void main(String[] args) {
        PrimeNumber obj = new PrimeNumber();
        //obj.printAllPrimeFactorsV2(30);
        System.out.println(obj.isPrime(25));
    }


    public boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void printAllPrimeFactors(int num) {

        for (int i = 2; i < num; i++) {

            if (isPrimeNumber(i)) {
                int x = i;
                while(num % x == 0) {
                    System.out.println(x);
                    x = x * i;
                }
            }
        }

    }

    public void printAllPrimeFactorsV2(int num) {
        if(num == 1 ) {
            return;
        }
        for (int i = 2; i < num; i++) {

            while (num % i == 0) {
                System.out.println(i);
                num = num / i;
            }
        }

        if(num > 1) {
            System.out.println(num);
        }

    }

    public boolean isPrime(int N) {
        if (N == 1) {
            return false;
        }

        if (N == 2 || N == 3) {
            return true;
        }

        if (N % 2 == 0 || N % 3 == 0) {
            return false;
        }

        for(int i = 5; i * i <= N; i = i + 6) {
            if( N % i == 0 || N % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }


    public static boolean[] seiveOfEratoSthenes(int n) {
        boolean [] isPrimes = new boolean[n+1];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = false;
        isPrimes[1] = false;

        for (int i = 2; i * i < n; i++) {

            for (int j = 2 * i; j < n; j += i) {
                isPrimes[j] = false;
            }
        }
        return isPrimes;
    }
}
