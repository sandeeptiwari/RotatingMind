package com.rotatingmind.array.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://codeforces.com/problemset/problem/713/A
public class SonyaAndQueries {



   /* static long solve(long temp) {
        m = 1;
        ans = 0;
        while (temp > 0) {
            ans += ((temp % 10) & 1) * m;
            m *= 2;
            temp /= 10;
        }
        return ans;
    }*/

    /**
     * The function solve(long n) processes the input number n by extracting each digit, checking if it's even or odd,
     * and constructing a new number where each digit is replaced by
     * 0 if it's even and 1 if it's odd. Here’s a step-by-step explanation of how the function works:
     *
     * Let's go through an example with n = 12345:
     *
     * First Iteration:
     *
     * n = 12345
     * re = (12345 % 10) % 2 = 5 % 2 = 1 (odd digit)
     * n = 12345 / 10 = 1234
     * rev = 1 * 10^0 + 0 = 1
     * count = 1
     * Second Iteration:
     *
     * n = 1234
     * re = (1234 % 10) % 2 = 4 % 2 = 0 (even digit)
     * n = 1234 / 10 = 123
     * rev = 0 * 10^1 + 1 = 1
     * count = 2
     * Third Iteration:
     *
     * n = 123
     * re = (123 % 10) % 2 = 3 % 2 = 1 (odd digit)
     * n = 123 / 10 = 12
     * rev = 1 * 10^2 + 1 = 100 + 1 = 101
     * count = 3
     * Fourth Iteration:
     *
     * n = 12
     * re = (12 % 10) % 2 = 2 % 2 = 0 (even digit)
     * n = 12 / 10 = 1
     * rev = 0 * 10^3 + 101 = 101
     * count = 4
     * Fifth Iteration:
     *
     * n = 1
     * re = (1 % 10) % 2 = 1 % 2 = 1 (odd digit)
     * n = 1 / 10 = 0
     * rev = 1 * 10^4 + 101 = 10000 + 101 = 10101
     * count = 5
     * End of Loop:
     *
     * n = 0 (loop terminates)
     */
    static long solve(long n) {
        long rev = 0;
        int count = 0;
        while (n > 0) {
            long re = (n % 10) % 2;
            n = n / 10;
            rev = (long) (re * Math.pow(10, count) + rev);
            count++;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(solve(870566619432760298l));
    }

    public static void main1(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        Map<Long, Long> mp = new HashMap<>();

        while (t > 0) {
            String[] s1 = br.readLine().split(" ");
            String c = s1[0];

            long n = Integer.parseInt(s1[1]);
            var num = solve(n);

            if (c.equals("+")) {
                mp.put(num, mp.getOrDefault(num, 0l) + 1);
            } else if (c.equals("-")) {
                if (mp.containsKey(num)) {
                    long cnt = mp.get(num);
                    cnt = cnt - 1;
                    mp.put(num, cnt);
                }
            } else if (c.equals("?")) {
                int cnt = 0;
                if (mp.containsKey(n)) {
                    cnt += mp.get(n);
                }
                System.out.println(cnt);
            }
            t--;

        }

    }
}
