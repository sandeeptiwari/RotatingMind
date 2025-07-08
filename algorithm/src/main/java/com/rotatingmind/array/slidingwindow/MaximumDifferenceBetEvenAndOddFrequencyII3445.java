package com.rotatingmind.array.slidingwindow;

/**
 * You are given a string s and an integer k. Your task is to find the maximum difference between the frequency of two characters, freq[a] - freq[b], in a substring subs of s, such that:
 *
 * subs has a size of at least k.
 * Character a has an odd frequency in subs.
 * Character b has an even frequency in subs.
 * Return the maximum difference.
 *
 * Note that subs can contain more than 2 distinct characters.
 *
 * Example 1:
 * Input: s = "12233", k = 4
 *
 * Output: -1
 *
 * Explanation:
 *
 * For the substring "12233", the frequency of '1' is 1 and the frequency of '3' is 2. The difference is 1 - 2 = -1.
 *
 * Example 2:
 *
 * Input: s = "1122211", k = 3
 *
 * Output: 1
 *
 * Explanation:
 *
 * For the substring "11222", the frequency of '2' is 3 and the frequency of '1' is 2. The difference is 3 - 2 = 1.
 *
 * Example 3:
 *
 * Input: s = "110", k = 3
 *
 * Output: -1
 *
 * Constraints:
 *
 * 3 <= s.length <= 3 * 104
 * s consists only of digits '0' to '4'.
 * The input is generated that at least one substring has a character with an even frequency and a character with an odd frequency.
 * 1 <= k <= s.length
 */
public class MaximumDifferenceBetEvenAndOddFrequencyII3445 {

    public int maxDifference(String s, int k) {

        int i = 0;
        int j = 0;
        int n = s.length();
        int maxDiff = Integer.MIN_VALUE;


        int[] freq = new int[10];

        while(j < n) {
            freq[s.charAt(j) - '0'] += 1;

            if ((j - i + 1) == k) {
                int maxOdd = Integer.MIN_VALUE;
                int minEven = Integer.MAX_VALUE;

                for (int d = 0; d < 10; d++) {
                    if (freq[d] > 0) {
                        if (freq[d] % 2 == 0) {
                            minEven = Math.min(minEven, freq[d]);
                        } else {
                            maxOdd = Math.max(maxOdd, freq[d]);
                        }
                    }
                }

                if (maxOdd != Integer.MIN_VALUE && minEven != Integer.MAX_VALUE) {
                    maxDiff = Math.max(maxDiff, maxOdd - minEven);
                }

                i++;
                freq[s.charAt(i) - '0'] -= 1;
            }
            j++;
        }

        return maxDiff == Integer.MIN_VALUE ? -1 : maxDiff;
    }


    public static void main(String[] args) {
        MaximumDifferenceBetEvenAndOddFrequencyII3445 obj = new MaximumDifferenceBetEvenAndOddFrequencyII3445();
        //System.out.println(obj.maxDifference("12233", 4));
        //System.out.println(obj.maxDifference("1122211", 3));
        //System.out.println(obj.maxDifference("110", 3));
        System.out.println(obj.maxDifference("300", 2)); // -1
    }

}
