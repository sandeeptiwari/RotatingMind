package com.rotatingmind.math.lcm;

public class FindCountOfEleWhichDivByAOrB {

    /**
     * First check how many elements are only divisible by a or b, for b count  = n / b
     * Lets say n = 20, a, 2, b = 3
     *
     * count = 20 / 3 = 6, means between 1 to 20 there would be 6 diff number which would be divisible by 3
     *
     * Now thing lcm would be intersection for both means divisible by both so if we would do :
     *
     *  n / 2 + n / 3 - ( no of lcm in this array ) =  count
     *
     *  count = (n / a) + (n / b) - (n / lcm (a, b))
     *
     */
    public int count(int n, int a, int b) {
        return 1;
    }
}
