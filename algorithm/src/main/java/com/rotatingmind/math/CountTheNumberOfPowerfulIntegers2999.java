package com.rotatingmind.math;

import java.util.Arrays;

public class CountTheNumberOfPowerfulIntegers2999 {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long strVal = Integer.parseInt(s);

        if (finish < strVal || finish - start < limit) {
            return 0;
        }

        long count = strVal > start ? 1 : 0;
        long digitInS = s.length();
        long digitInFinish = (long)Math.floor(Math.log10(finish)) + 1;
        long base = (long)Math.pow(10, digitInFinish-1);

        while (finish - strVal >= base) {

            strVal = strVal + base;

            if (strVal / base > limit) {
                break;
            }

            count++;
        }

        return count;
    }

        private int limit;
        private String suffixStr;
        private int suffixLen;
        private long[][] dp;

        public long numberOfPowerfulInt1(long start, long finish, int limit, String s) {
            this.limit = limit;
            this.suffixStr = s;
            this.suffixLen = s.length();
            return countPowerful(String.valueOf(finish)) - countPowerful(String.valueOf(start - 1));
        }

        private long countPowerful(String numStr) {
            int n = numStr.length();
            dp = new long[n][2]; // dp[i][tight]
            for (long[] row : dp) {
                Arrays.fill(row, -1);
            }
            return solve(0, 1, numStr);
        }

        private long solve(int index, int tight, String numStr) {
            if (index > numStr.length() - 1) {
                return 1;
            }

            if (dp[index][tight] != -1) {
                return dp[index][tight];
            }

            long count = 0;
            int upper = tight == 1 ? (numStr.charAt(index) - '0') : 9;
            int lower = 0;

            for (int digit = lower; digit <= upper; digit++) {
                if (index >= numStr.length() - suffixLen) {
                    int suffixIndex = index - (numStr.length() - suffixLen);
                    if (digit != (suffixStr.charAt(suffixIndex) - '0')) {
                        continue;
                    }
                }

                if (digit > limit) {
                    continue;
                }

                int newTight = tight & (digit == upper ? 1 : 0);
                count += solve(index + 1, newTight, numStr);
            }

            return dp[index][tight] = count;
        }

    public static void main(String[] args) {
        CountTheNumberOfPowerfulIntegers2999 obj = new CountTheNumberOfPowerfulIntegers2999();
        //System.out.println(obj.numberOfPowerfulInt(1, 6000, 4, "124"));
        //System.out.println(obj.numberOfPowerfulInt(15, 215, 6, "10"));
        //System.out.println(obj.numberOfPowerfulInt(1000, 2000, 4, "3000"));
        System.out.println(obj.numberOfPowerfulInt(141, 148, 9, "9"));
    }
}
