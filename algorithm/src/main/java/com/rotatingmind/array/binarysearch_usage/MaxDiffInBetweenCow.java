package com.rotatingmind.array.binarysearch_usage;

/**
 * A farmer has N stall, located at some position
 * no of cow = 3
 * no of sttal = 3
 * N = 5
 *
 * case 1: can I place all these cow (C). s.t. adjusent diff > 4
 *
 * 1-- 20
 *
 * placement = (1, 8, 15 )
 * diff > 4 for any of 2 cow
 *
 * if start placement from 2 stall
 *
 * (2, 8, 15)
 *
 * n log(h -l)
 */
public class MaxDiffInBetweenCow {


    public int getDiff(int[] a, int c, int n) {
        int l = 1, h = 8;
        while (l <= h) {
            int m = (l + h ) / 2;
            boolean canPlace = isAblePlaced(a, m, c, n);

            if (!canPlace) {
                h = m -1;
            } else {
                boolean canPlace1 = isAblePlaced(a, m + 1, c, n);

                if (!canPlace1) return m;
                else l = m + 1;

            }
        }
        return 0;
    }

    /**
     *
     * @param mid
     * @param c = #cow
     * @param n = total stalls
     * @return
     */
    public boolean isAblePlaced(int[] a, int mid, int c, int n) {
        int prev = a[0];
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            if (a[i] - prev > mid) {
                continue;
            } else {
                cnt++;
                prev = a[i];
            }
        }
        return cnt >= c;
    }
}
