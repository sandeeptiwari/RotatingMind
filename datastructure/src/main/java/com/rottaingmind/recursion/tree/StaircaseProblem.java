package com.rottaingmind.recursion.tree;

import java.util.HashMap;
import java.util.Map;

public class StaircaseProblem {

    /**
     * DP: store result in an array
     * @param num
     * @return
     */
    public static int waysToClimb(int num, int[] possibleSteps) {
        if (num == 1)
            return 1;
        int nbWays = 0;

        for (int steps: possibleSteps) {
            int remain = num - steps;
            if (remain >= 0) {
                nbWays += waysToClimb(remain, possibleSteps);
            }
        }
      return nbWays;
    }

    public static int waysToClimbV1(int num) {
        int one = 1, two = 1;

        for (int i = 0; i < num - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
      return one;
    }

    public static int waysToClimbV2(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i -1] + dp[i-2];
        }
        return dp[n];
    }

    public static int waysToClimbV3(int n) {

           return 0;
    }


    public static int climbStairs(int n,  Map<Integer, Integer> cache) {

        if(n==1 || n==0){
            return 1;
        }
        if(n>1){
            if(!cache.containsKey(n-1)){
                cache.put(n-1,climbStairs(n-1, cache));
            }
            if(!cache.containsKey(n-2)){
                cache.put(n-2,climbStairs(n-2, cache));
            }
            return cache.get(n-1) + (int)cache.get(n-2);
        }

        return n;
    }



    public static void main(String[] args) {
        Map<Integer, Integer> cache = new HashMap<>();
        int steps = climbStairs(10, cache);
        System.out.println("Steps:: " + steps);
        int[] possibleSteps = {2, 4, 5, 8};
        System.out.println(waysToClimbV2(10));
    }
}
