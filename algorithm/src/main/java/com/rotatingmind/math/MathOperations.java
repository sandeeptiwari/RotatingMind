package com.rotatingmind.math;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathOperations {

    public static void main(String[] args) {
        MathOperations mathOperations = new MathOperations();
        //boolean primes[] = seiveOfEratoSthenes(20);

        //for (int i = 0; i < 20; i++) {
        //    System.out.println(i + " " + primes[i]);
       // }
        mathOperations.findTheSumUptoSingleDigit(547674);

    }

    public double fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public int countTrailingByZeroInFactorial(int num) {
        int result = num / 5;
        for (int i = 0; i < num; i = i * 5) {

            result += num / i;
        }
       return result;
    }

    public boolean isNumberPalindrome(int num) {
        int sum = 0, result = num;
        while(num > 0) {
            int rem = num % 10;
            sum = rem + sum * 10;
            num = num / 10;
        }
        return sum == result;
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
        return isPrimes;/*IntStream.range(0, isPrimes.length)
                .mapToObj(idx -> isPrimes[idx]).filter(ele -> ele).collect(Collectors.toList())*/
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    int n = 2;
    public void factorOfNumber(int num) {

        while (n < num / 2) {

            if (num % n == 0) {
                System.out.println(" FACTOR " + n);
            }
            n++;
        }
    }

    public void findTheSumUptoSingleDigit(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            num = num / 10;
        }
        System.out.println(" SUM " + sum);
    }
}
