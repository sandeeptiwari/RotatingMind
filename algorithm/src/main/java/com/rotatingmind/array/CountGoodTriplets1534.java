package com.rotatingmind.array;

/**
 * Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.
 * <p>
 * A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
 * <p>
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * Where |x| denotes the absolute value of x.
 * <p>
 * Return the number of good triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * Output: 4
 * Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].
 * Example 2:
 * <p>
 * Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * Output: 0
 * Explanation: No triplet satisfies all conditions.
 * <p>
 * Constraints:
 * <p>
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 */
public class CountGoodTriplets1534 {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i <= n - 3; i++) {

            for (int j = i + 1; j <= n - 2; j++) {

                for (int k = j + 1; k <= n - 1; k++) {

                    var condi1 = Math.abs(arr[i] - arr[j]);
                    var condi2 = Math.abs(arr[j] - arr[k]);
                    var condi3 = Math.abs(arr[i] - arr[k]);

                    //|arr[i] - arr[j]| <= a
                    //|arr[j] - arr[k]| <= b
                    //|arr[i] - arr[k]| <= c

                    if (condi1 <= a && condi2 <= b && condi3 <= c) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int countGoodTripletsV1(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i <= n - 3; i++) {

            for (int j = i + 1; j <= n - 2; j++) {
                 var condi1 = Math.abs(arr[i] - arr[j]);

                if (condi1 <= a) {
                    for (int k = j + 1; k <= n - 1; k++) {

                        var condi2 = Math.abs(arr[j] - arr[k]);
                        var condi3 = Math.abs(arr[i] - arr[k]);

                        //|arr[i] - arr[j]| <= a
                        //|arr[j] - arr[k]| <= b
                        //|arr[i] - arr[k]| <= c

                        if (condi2 <= b && condi3 <= c) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountGoodTriplets1534 obj = new CountGoodTriplets1534();
        int[] arr = {3, 0, 1, 1, 9, 7};
        System.out.println(obj.countGoodTriplets(arr, 7, 2, 3));
    }

}
