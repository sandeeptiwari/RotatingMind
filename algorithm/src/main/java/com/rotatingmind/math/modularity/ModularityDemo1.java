package com.rotatingmind.math.modularity;

/**
 *  1: (a-b) % m = in this cae if  a-b < m then add m
 *  (10 - 4) % 7 = 6 but if we distribute it
 *  10 % 7 = 3
 *  4 % 7 = 4
 *  (3 - 4) = -1 now we have to add 7 in result = -1 + 7 = 6
 *
 *  2: (a*b) % m = (a % m * b % m) % m
 *
 *  3: (a+b) % m = (a%m + b%m) % m
 *  k = x + y => k - y = x
 */
public class ModularityDemo1 {

    /**
     * Array contains non negative values, Now count the no of pairs such that
     * a[i] + a[j] is divide by k
     */

    public static int getPair(int[] a, int k) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((a[i] + a[j]) % k == 0) {
                    count++;
                }
            }

        }
        return count;
    }

    /**
     * (a[i] + a[j]) % k where (a[i] + a[j]) is rem of sum
     * (a[i] + a[j]) % k = (a[i] % k + a[j] % k ) % k
     * values must lies  0 .. k-1 and 0 ... k -1 = [0, 2k -2]
     * a[i] % k + a[j] % k  this expression yield you 0 if and only if  (a[i] % k + a[j] % k) would be multiple of k
     * here lets say a[i] % k = r1,  a[j] % k = r2
     * r1+r2 = 0 its only possible when r1 = r2
     * r1 = 1
     * r2 = k-1 (because possible value of multiple of r1 and r2 would between 0 to 2k -2) either 0 OR k.
     * r = 2 & r2 = k-2 .....
     */
    public static int getPairV1(int[] a, int k) {
        int n = a.length;
        int count = 0;
        //define array to store all reminder till k
        int [] rem = new int[k];

        for (int i = 0; i < n; i++) {
            // lets say num at ith position in 5 and k = 4 then rme = 1 and it will store at 1st index and again got incremented for 9 because 9 % 4 = 1
            int value = a[i] % k;
            System.out.println("a[i] = " + a[i] + " Value " + value);
            rem[value] = rem[value] + 1;
        }

        //specially for zeroth index mean all numbers which has given 0 as a reminder
        count += (rem[0] * (rem[0] - 1)) / 2;

        for (int i = 1; i <= (k/2 - 1); i++) {
            count+= rem[i] * rem[k-i]; // i & k-i is 2 bucket we would have total i * k-i total choices for individual pair selection
        }

        if (k % 2 == 0) {
            count +=(rem[k/2]*(rem[k/2]-1))/2;
        } else {
            count += rem[k/2] * (rem[k/2] + 1); // in case of odd we would have this much choice to select
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 1, 7, 5, 3};
        int k = 4;

        System.out.println(getPairV1(a, k));
    }
}
