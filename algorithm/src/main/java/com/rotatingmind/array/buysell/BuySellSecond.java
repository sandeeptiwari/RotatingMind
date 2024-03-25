package com.rotatingmind.array.buysell;

import java.util.ArrayList;
import java.util.List;

public class BuySellSecond {

    public static int maxProfit(int index, boolean buy, int[] prices, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }
        int b = buy ? 1 : 0;
        if (dp[index][b] != -1) {
            return dp[index][b];
        }
        int profit = 0;

        if (buy) {
            int buyKaro = -prices[index] + maxProfit(index+1, !buy, prices, dp);
            int skipKaro = (0 + maxProfit(index + 1, buy, prices, dp));

            profit = Math.max(buyKaro, skipKaro);
        } else {
            int sellKaro = prices[index] + maxProfit(index+1, !buy, prices, dp);
            int skipKaro = (0 + maxProfit(index + 1, buy, prices, dp));

            profit = Math.max(sellKaro, skipKaro);
        }
        dp[index][b] = profit;
        return dp[index][b];
    }


    public static int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for (int i = 1; i < n-1; i++) {
            if (prices[i] > prices[i-1]) {
                profit += (prices[i] - prices[i-1]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int[][] dp = new int[a.length][2] ;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Profit => " + maxProfit(0, true, a, dp));
        //System.out.println("Profit => " + maxProfit(a));
    }
}
