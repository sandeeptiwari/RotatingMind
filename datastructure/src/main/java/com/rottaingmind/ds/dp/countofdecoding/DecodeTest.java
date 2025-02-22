package com.rottaingmind.ds.dp.countofdecoding;

public class DecodeTest {

    public static int numDecodings(String s) {
        int n = s.length();
        int[] ans = new int[n];

        if (s.startsWith("0")) return 0;

        ans[0] = isValid(s.charAt(0) - '0', 1) ? 1 : 0;

        if (n == 1) return ans[0];

        if (isValid(s.charAt(1) - '0', 1)) {
            ans[1]++;
        }

        if (isValid((s.charAt(0) - '0') * 10  + s.charAt(1) - '0', 2)) {
            ans[1]++;
        }

        for (int i = 2; i < n; i++) {

            if (isValid(s.charAt(i) - '0', 1)) {
                ans[i] += ans[i - 1];
            }

            if (isValid((s.charAt(i - 1)- '0') * 10 + s.charAt(i) - '0', 2)) {
                ans[i] += ans[i - 2];
            }
        }

        return ans[n -1];
    }


    public static int numDecodingsV1(String s) {
        int n = s.length();
        //int[] ans = new int[n];

        if (s.startsWith("0")) return 0;

        int prev2 = 1; // Represents ans[i - 2] (Base case: empty string has 1 way)
        int prev1= isValid(s.charAt(0) - '0', 1) ? 1 : 0;

        if (n == 1) return prev1;

        /*if (isValid(s.charAt(1) - '0', 1)) {
            prev1++;
        }*/

        if (isValid((s.charAt(0) - '0') * 10  + s.charAt(1) - '0', 2)) {
            prev1++;
        }



        for (int i = 2; i < n; i++) {
            int curr = 0;
            if (isValid(s.charAt(i) - '0', 1)) {
                curr += prev1;
            }

            if (isValid((s.charAt(i - 1)- '0') * 10 + s.charAt(i) - '0', 2)) {
                curr += prev2;
            }
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static boolean isValid(int code, int len) {
        if (len == 1)
            return code >= 1 && code <= 9;

        else return code >= 10 && code <= 26;
    }

    public static void main(String[] args) {
        String s = "10";
        System.out.println(numDecodingsV1(s));
        System.out.println(numDecodingsV1("226"));
        System.out.println(numDecodingsV1("12"));
    }
}
