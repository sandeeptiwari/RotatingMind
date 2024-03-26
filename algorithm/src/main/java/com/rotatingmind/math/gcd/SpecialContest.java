package com.rotatingmind.math.gcd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Bob and Alice are participating in a contest. There are
 * N
 * problems in this contest; each problem has a unique problem code between
 * 1
 * and
 * N
 * inclusive. Bob and Alice decided to split the problems to solve between them ― Bob should solve the problems whose problem codes are divisible by
 * A
 * but not divisible by
 * B
 * , and Alice should solve the problems whose problem codes are divisible by
 * B
 * but not divisible by
 * A
 * (they decided to not solve the problems whose codes are divisible by both
 * A
 * and
 * B
 * ).
 * <p>
 * To win, it is necessary to solve at least
 * K
 * problems. You have to tell Bob whether they are going to win or lose.
 *
 * Input
 * 1
 * 6 2 3 3
 * Output
 * Win
 */
public class SpecialContest {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();

        int cases = Integer.parseInt(line1);


        for (int i = 0; i < cases; i++) {
            String[] str = br.readLine().split(" ");
            long n = Long.parseLong(str[0]);
            long a = Long.parseLong(str[1]);
            long b = Long.parseLong(str[2]);
            long k = Long.parseLong(str[3]);

            specialContest(n, a, b, k);
        }


    }

    public static long gcd(long a, long b) {

        if (a == b) return a;


        long divisor = Math.min(a, b);

        long dividend = Math.max(a, b);

        long remainder = dividend % divisor;


        while (remainder != 0) {

            dividend = divisor;

            divisor = remainder;

            remainder = dividend % divisor;

        }


        return divisor;

    }

    public static long lcm(long a, long b) {
        long gcd = gcd(a, b);
        return (a * b) / gcd;
    }

    public static void specialContest(long n, long a, long b, long k) {
        long check = (n / a) + (n / b) - ((n / lcm(a, b)) * 2);
        if (check >= k) {
            System.out.println("Win");
        } else {
            System.out.println("Lose");
        }
    }

}
