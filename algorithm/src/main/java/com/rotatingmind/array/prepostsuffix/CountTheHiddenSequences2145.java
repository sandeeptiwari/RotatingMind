package com.rotatingmind.array.prepostsuffix;

public class CountTheHiddenSequences2145 {


    /**
     * Example 1:
     *
     * Input: differences = [1,-3,4], lower = 1, upper = 6
     * Output: 2
     * Explanation: The possible hidden sequences are:
     * - [3, 4, 1, 5]
     * - [4, 5, 2, 6]
     * -[5, 6, 3, 7]
     * Thus, we return 2.
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int count = 0;

        for (int i = lower; i <= upper; i++) {
            if (isValidSequence(i, differences, lower, upper)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValidSequence(int start, int[] differences, int lower, int upper) {
        long current = start;
        if (current < lower || current > upper) {
            return false;
        }

        for (int diff : differences) {
            current += diff;
            if (current < lower || current > upper) {
                return false;
            }
        }

        return true;
    }

    /**
     * Example 1:
     *
     * Input: differences = [1,-3,4], lower = 1, upper = 6
     * Output: 2
     * Explanation: The possible hidden sequences are:
     * - [3, 4, 1, 5]
     * - [4, 5, 2, 6]
     * -[5, 6, 3, 7]
     * Thus, we return 2.
     */
    public int numberOfArraysV1(int[] differences, int lower, int upper) {
        int minVal = 0;
        int maxVal = 0;
        int currVal = 0;// Simulates building the array starting from a[0] = 0

        for (int diff : differences) {
            currVal += diff;
            minVal = Math.min(minVal, currVal);
            maxVal = Math.max(maxVal, currVal);

            if ((upper - maxVal) - (lower - minVal) + 1 <= 0 ) {
                return 0;
            }
        }


        return (upper - maxVal) - (lower - minVal) + 1;
    }

    public static void main(String[] args) {
        CountTheHiddenSequences2145 obj = new CountTheHiddenSequences2145();
        int [] a = {1,-3,4};
        int [] a1 = {-40};
       // int res = obj.numberOfArrays(a, 1, 6);
        int res1 = obj.numberOfArraysV1(a1, -46, 53);
        //System.out.println("Result1 " + res);
        System.out.println("Result2 " + res1);
    }
}
