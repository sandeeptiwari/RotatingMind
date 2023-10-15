package com.rotatingmind.array;


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


    private int maxProfit(int[] prices) {
        int minProfit = prices[0];
        int maxProfit = 0;
        int len = prices.length;

        for (int i = 1; i < len; i++) {
            minProfit = Math.min(minProfit, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minProfit);
        }
        return maxProfit;
    }


    /*public static void main(String[] args) {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String secretString = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("Secret key: " + secretString);
    }*/
}
