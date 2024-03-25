package com.rotatingmind.recursion;

public class RecursiveDigitSum {

    public static int superDigit(String n, int k) {
        String p = n;

        for (int i = 1; i < k; i++) {
            p += n;
        }

        return superDigit(p);
    }

    public static int superDigit(String p) {
        if (p.length() == 1) {
            return Integer.parseInt(p);
        }

        int sum = 0;
        for (int i = 0; i < p.length(); i++) {
            sum += Integer.parseInt("" + p.charAt(i));
        }
        p = "" + sum;
        return superDigit(p);
    }


    public static int superDigitV1(String n, int k) {
        // Write your code here
        if (n.length() == 1 && k == 1) {
            return Integer.valueOf(n);
        } else {
            String[] digits = n.split("");
            long sum = 0;
            for (String digit : digits) {
                sum += Integer.valueOf(digit);
            }
            sum = sum * k;
            return superDigit(String.valueOf(sum), 1);
        }

    }

    public static void main(String[] args) {
        int res = superDigitV1("861568688536788", 100000);
        System.out.println(res);
    }


}
