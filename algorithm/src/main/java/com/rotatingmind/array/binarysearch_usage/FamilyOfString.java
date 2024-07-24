package com.rotatingmind.array.binarysearch_usage;

/**
 * Ok I will be assuming that you know what does lower_bound function do.
 *
 *
 *
 * 1. We are iterating from the back (you can do from the front also) and adding the values in a set that are
 * x indexes apart from the current index.
 *
 * 2. We are searching for the lower bound of the current index value on the set.
 *
 * 3. Then simpy applying the condition of finding the mid value difference or lower than that.
 */
public class FamilyOfString {

    public int search(int[] s, int n, int k) {
        int l = 0;
        int h = (int)Math.pow(2, n + 1) - 2;
        int bit = 0;

        while(l <= h) {
            int mid = l + h / 2;

            if (mid == k) return bit;
            else if (mid < k) {
                l = mid + 1;
                bit = 1 - bit;
            } else {
                h = mid - 1;
            }
        }

        return -1;
    }
}
