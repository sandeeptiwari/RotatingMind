package com.rotatingmind.array.buysell;

import java.util.ArrayList;
import java.util.List;


/**
 * We can buy and sell the stock any number of times.
 * In order to sell the stock, we need to first buy it on the same or any previous day.
 * We can’t buy a stock again after buying it once. In other words, we first buy a stock and then sell it. After selling
 * we can buy and sell again. But we can’t sell before buying and can’t buy before selling any previously bought stock.
 */
public class BuySellSecond {

    public static int maxProfit(int index, int buy, int[] prices, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }
       if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        int profit = 0;

        if (buy == 0) {
            int buyKaro = -prices[index] + maxProfit(index+1, 1, prices, dp);
            int skipKaro = (0 + maxProfit(index + 1, buy, prices, dp));

            profit = Math.max(buyKaro, skipKaro);
        } else {
            int sellKaro = prices[index] + maxProfit(index+1, 0, prices, dp);
            int skipKaro = (0 + maxProfit(index + 1, 1, prices, dp));

            profit = Math.max(sellKaro, skipKaro);
        }
        dp[index][buy] = profit;
        return dp[index][buy];
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

        System.out.println("Profit => " + maxProfit(0, 0, a, dp));
        //System.out.println("Profit => " + maxProfit(a));
    }
}
