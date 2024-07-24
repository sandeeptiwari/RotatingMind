package com.rotatingmind.array.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * in Screenshot with same name
 */
public class ArthurAndTable {


    public static int getMinSpendEnergy(int[] l, int[] d) {
        int n = l.length;

        if (n == 1) {
            return 0;
        } else if (n == 2 && l[0] == l[1]) {
            return 0;
        } else {
            Map<Integer, Integer> freqByLeg = new HashMap<>();
            int reqForBalance = 0;
            if (n %2 == 0) {
                reqForBalance =  (int) Math.ceil(n / 2);
            } else {
                reqForBalance  = (int) Math.floor(n / 2) + 1;
            }
            int max = Arrays.stream(l).max().getAsInt();

            for (int i = 0; i < n; i++) {
                freqByLeg.merge(l[i], 1, Integer::sum);
            }

            if (n != 2 && freqByLeg.get(max) == reqForBalance) {
                return 0;
            } else {
                int needToRemove = n - reqForBalance;
                int sum = 0;
                int window = needToRemove;
                int j = 0, k = window;

                for (int i = 0; i < window; i++) {
                    sum += d[i];
                }
                int currSum = sum;

                for (int i = window; i < n; i++) {

                    currSum -= d[i - window];
                    currSum += d[i];

                    if (sum > currSum) {
                        sum = currSum;
                        j = window - 1;
                        k = window;
                    }
                }

                return sum;
            }
        }
    }

    public static void main(String[] args) {
        int[] l = {2, 4, 4};
         int[] d = {1, 1, 1};

        int[] l1 = {2, 2, 1, 1, 3, 3};
        int[] d1 = {4, 3, 5, 5, 2, 1};

        int[] l2 = {1, 5};
        int[] d2 = {3, 2};

        System.out.println(getMinSpendEnergy(l1, d1));
    }


}
