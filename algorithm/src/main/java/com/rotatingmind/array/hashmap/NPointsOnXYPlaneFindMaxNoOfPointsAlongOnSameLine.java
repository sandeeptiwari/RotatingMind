package com.rotatingmind.array.hashmap;

/**
 * Lets say P(x, Y), many lines can pass from this point, but slope would be different as per line equation
 * y = mx + c => m would be vary as per line, But lets say p1, p2, p3 and p4 lies on same line L1, then if calculate slope
 * of L1 for each points, the slope of each points would be constants
 *
 * dy/dx = (y' - y)/(x'-x) = (y'' - y) / (x'' - x)
 *
 * So if we calculate slope of each points from point p1, the  max  frequency of slop would be our answer.
 *
 * if we consider
 * P0 [p1, p2, .....pn-1]
 * P1 [p2, p3, .....pn-1]
 *
 * Pi [pi+1, pi+2, .....pn-1]
 *
 *We can not take integer datatype for this because point can be in decimal format as well, precision cant be avoided
 * to track frequencies as Pair<int, int>
 *
 * we have to reduce faction their lowest form, to do this divide by gcd of both denominator and nominator
 *
 * ==> 5/0, 6/0 here we have to consider gcd would be non zero ele which is converted (1, 0)
 * ==> coincident points (0, 0) here x and y both is same, we store frequency  of these differently
 * ==> sign can we ignore ::  2/ -3, -2/3 => (-2,3) or (2, -3) for all cases
 *
 * total = 1, + overlapping point + max Frequency of slop (this would be our answer)
 *
 * for different point we have to refresh frequency map as well
 *
 *
 */
public class NPointsOnXYPlaneFindMaxNoOfPointsAlongOnSameLine {

    /**
     * Map<> init
     * 1- loop from i to n-1
     *    int olp, maxFreq = 0
     * 2- nested loop from i + 1 to n-1
     *    i - check olp and incrment olp++
     *    ii - calculate slop xDiff = x-x', and yDiff = y-y'
     *    iii - gcd of both slop int g = gcd (abs(xDiff), (yDiff))
     *    iV - int f = xDiff / g
     *    v - int s = yDiff / g
     *    standardize(f, s)
     *    store in map
     *    check frequency
     *    clear map
     *    see reference mapoint img
     *
     *  TC n^2 log(n)
     * @param points
     * @return
     */
    public int maxPoint(int[][] points) {
      return 0;
    }

    public int gcd(int v1, int v2) {
        if(v1 == 0) return v2;
        if(v2 == 0) return v1;

        int m1 = Math.max(v1, v2);
        int m2 = Math.min(v1, v2);

        if (m1 / m2 == 0) return m2;

        return gcd(m1 / m2, m2);
    }

}
