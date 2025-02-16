package com.rottaingmind.ds.dp.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record EnvelopPair(int w, int h) {}

public class EnvelopCh10 {


    private int Lip(int prevIndex, int currIndex, EnvelopPair[] envelopes) {

        if (currIndex >= envelopes.length) {
            return 0;
        }

        int include = 0;

        if (prevIndex == -1 ||
                (envelopes[currIndex].w() > envelopes[prevIndex].w() &&
                        envelopes[currIndex].h() > envelopes[prevIndex].h())) {
            include = 1 + Lip(currIndex, currIndex + 1, envelopes);
        }

        int exclude = Lip(prevIndex, currIndex + 1, envelopes);

        return Math.max(include, exclude);
    }


    private int Lip(EnvelopPair[] envelopes, int[] dp) {

        int n = envelopes.length;
        dp[0] = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (envelopes[i].h() > envelopes[j].h() && envelopes[i].w() > envelopes[j].w()) {
                    dp[i] = Math.max(dp[i], 1 + dp[j] );
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public int maxEnvelopesV1(int[][] envelopes) {
        int n = envelopes.length;
        EnvelopPair[] envPairs = new EnvelopPair[n];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // Convert array to EnvelopPair and sort
        for (int i = 0; i < n; i++) {
            envPairs[i] = new EnvelopPair(envelopes[i][0], envelopes[i][1]);
        }

        //sort the array
        Arrays.sort(envPairs, (e1, e2) -> e1.w() == e2.w() ? e2.h() - e1.h() : e1.w() - e2.w());

        return Lip(envPairs, dp);

    }


    /**
     * Sorting Normally (Both Width and Height in Ascending Order)
     * Let’s say we have the following envelopes:
     *
     * scss
     * Copy
     * Edit
     * (5,4), (6,7), (6,4), (2,3)
     * Sorting by Width and Height in Ascending Order
     * If we sort both width and height in ascending order:
     *
     * scss
     * Copy
     * Edit
     * (2,3), (5,4), (6,4), (6,7)
     * 🔹 Issue:
     *
     * If we simply apply Longest Increasing Subsequence (LIS) on height, we might wrongly pick (6,4) → (6,7), which is not valid since width is the same 6 == 6, but 4 < 7.
     * We must ensure that for equal widths, we do not consider smaller heights first, since that could allow invalid sequences.
     *
     *
     * Step 2: Sorting Width Ascending, Height Descending
     * Instead, we sort as:
     *
     * Sort width in ascending order → (2,3), (5,4), (6,7), (6,4)
     * For equal width, sort height in descending order → (2,3), (5,4), (6,7), (6,4)
     * ✅ Now, applying LIS on only heights will give the correct answer, because 6,7 comes before 6,4, preventing an invalid sequence.
     *
     * Conclusion
     * 🔹 Sorting by (width ASC, height DESC) ensures that we can apply LIP only on heights!
     * 🔹 Sorting (width ASC, height ASC) can lead to invalid subsequences in LIP.
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        EnvelopPair[] envPairs = new EnvelopPair[n];

        // Convert array to EnvelopPair and sort
        for (int i = 0; i < n; i++) {
            envPairs[i] = new EnvelopPair(envelopes[i][0], envelopes[i][1]);
        }

        // Sort by width asc, height desc for correct sequence formation
        Arrays.sort(envPairs, (a, b) -> a.w() == b.w() ? Integer.compare(b.h(), a.h()) : Integer.compare(a.w(), b.w()));

        return Lip(-1, 0, envPairs);
    }


    /**
     * Understanding Rotation
     * Each envelope (w, h) can be used in two ways:
     *
     * As given: (w, h)
     * Rotated: (h, w)
     * 🔹 Rule for rotation:
     *
     * Always ensure width is the smaller dimension (w ≤ h).
     * If w > h, swap them to maintain consistency.
     */


    public static void main(String[] args) {
        EnvelopCh10 obj = new EnvelopCh10();
        int[][] envelopes = { {5,4}, {6,4}, {6,7}, {2,3} };
        //System.out.println(obj.maxEnvelopes(envelopes)); // Output: 3
        System.out.println(obj.maxEnvelopesV1(envelopes)); // Output: 3
    }
}
