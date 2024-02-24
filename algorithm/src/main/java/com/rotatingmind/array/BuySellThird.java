package com.rotatingmind.array;

import java.util.Arrays;

public class BuySellThird {

    public static int maxProfit(int[] a, int i, int buy, int limit) {
        if(a.length == i) {
            return 0;
        }

        if(limit == 0) {
            return 0;
        }
        int profit = 0;

        if (buy == 0) {
            int buyKro = -a[i] + maxProfit(a, i + 1, 1, limit);
            int skipKro = 0 + maxProfit(a, i + 1, 0, limit);

            profit = Math.max(buyKro, skipKro);
        } else {
            int sellKro = a[i] + maxProfit(a, i + 1, 0, limit-1);
            int skipKro = 0 + maxProfit(a, i + 1, 0, limit);

            profit = Math.max(sellKro, skipKro);
        }
        return profit;
    }


    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[] prefixMin = new int[n];
        int[] suffixMax = new int[n];
        int[] mx = new int[n];

        Arrays.fill(prefixMin, Integer.MAX_VALUE);
        suffixMax[n - 1] = -1;

        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], prices[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], prices[i + 1]);
        }

        mx[n - 1] = suffixMax[n - 1] - prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            mx[i] = Math.max(mx[i + 1], suffixMax[i] - prices[i]);
        }

        int ans = 0;

        for (int i = 1; i < n; i++) {
            int val = 0;
            if (prices[i] - prefixMin[i] > 0) {
                val += prices[i] - prefixMin[i];
                if (i + 1 < n && mx[i + 1] > 0) {
                    val += mx[i + 1];
                }
            }
            ans = Math.max(val, ans);
        }

        return ans;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        int n = 8;
        int[] a = {3, 3, 5, 0, 0, 3, 1, 4};

        int profit = maxProfit(a);
        System.out.print(profit);
    }
}
