package com.rotatingmind.array.buysell;


import javax.crypto.SecretKey;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Input: prices = [7,1,5,3,6,4]
 * Input: prices = [7,6,4,3,1]
 * Output: 5
 */
public class MaxProfitBuyAndSell {


    private static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        int len = prices.length;

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - min;
            profit = Math.max(profit, diff);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }


   /* public static void main(String[] args) {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String secretString = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("Secret key: " + secretString);
    }*/
}
