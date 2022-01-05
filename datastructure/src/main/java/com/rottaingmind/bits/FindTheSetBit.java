package com.rottaingmind.bits;

public class FindTheSetBit {

    public static void main(String[] args) {
        System.out.println(count(4));
    }

    public static int getFirstSetBit(int n) {

        // if n is odd return 1 because most right bit in odd number is 1
        if ((n & 1) != 0) {
            return 1;
        }

        // unset rightmost bit and xor with the number itself
        n = n ^ (n & (n - 1));

        // find the position of the only set bit in the result;
        // we can directly return `log2(n) + 1` from the function
        int pos = 0;

        while (n != 0) {
            n = n >> 1;
            pos++;
        }

        return pos;
    }

    /**
     * Given two numbers M and N. The task is to find the position of the rightmost different
     * bit in the binary representation of numbers.
     * Input: M = 11, N = 9
     * Output: 2
     * Explanation: Binary representation of the given
     * numbers are: 1011 and 1001,
     * 2nd bit from right is different.
     * @param m
     * @param n
     * @return
     */
    public static int posOfRightMostDiffBit(int m, int n)
    {

        int num = m ^ n;

        if ((num & 1) != 0) {
            return 1;
        }

        num = num ^ (num & (num -1));
        int pos = 0;

        while(num != 0) {
            num = num >> 1;
            pos++;
        }

        return pos;
    }


    /**
     * Input: N = 4, K = 0
     * Output: No
     *
     * Input: N = 4, K = 2
     * Output: Yes
     *
     * Input: N = 500, K = 3
     * Output: No
     *
     * Input: N = 20, K = 3
     * Output: Yes
     * @param n
     * @param k
     * @return
     */
    static boolean checkKthBit(int n, int k)
    {
        // return (n & (1<<k)) != 0; //--> way 1

        return ((n >> (k-1)) & 1) > 0;
    }

    public static int countSetBits1(int n){

        int count = 0;

        for(int i = 1; i <= n; i++) {
            int currentBits = 0;
            int num = i;
            while(num > 0) {
                currentBits = currentBits + (num & 1);
                num = num>>1;
            }
            count = count + currentBits;
        }
        return count;
    }

    public static int countSetBits(int n){
        if(n <= 0) {
            return 0;
        }

        int x = largestPowerOf2InRange(n);
        int bitsTill2x = x * (1 << (x-1));
        int msb2xton = n - (1 << x) + 1;
        int rest = n - (1 << x);
        int ans = bitsTill2x + msb2xton + countSetBits(rest);
        return ans;
    }

    public static int largestPowerOf2InRange(int n) {
        int x = 0;

        while((1<<x) < n) {
            x++;
        }
        return x - 1;
    }

    public static int count(int n) {
        // Ignore 0 as all the bits are unset
        n++;

        // To store the powers of 2
        int powerOf2 = 2;

        // To store the result, it is initialized
        // with n/2 because the count of set
        // least significant bits in the integers
        // from 1 to n is n/2
        int cnt = n / 2;

        // Loop for every bit required to represent n
        while (powerOf2 <= n)
        {

            // Total count of pairs of 0s and 1s
            int totalPairs = n / powerOf2;

            // totalPairs/2 gives the complete
            // count of the pairs of 1s
            // Multiplying it with the current power
            // of 2 will give the count of
            // 1s in the current bit
            cnt += (totalPairs / 2) * powerOf2;

            // If the count of pairs was odd then
            // add the remaining 1s which could
            // not be groupped together
            cnt += (totalPairs % 2 == 1) ?
                    (n % powerOf2) : 0;

            // Next power of 2
            powerOf2 <<= 1;
        }

        // Return the result
        return cnt;
    }
}
