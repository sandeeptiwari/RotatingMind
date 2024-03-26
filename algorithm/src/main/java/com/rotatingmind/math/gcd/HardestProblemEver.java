package com.rotatingmind.math.gcd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. For example, the sequence
 * [
 * A
 * ,
 * B
 * ,
 * D
 * ]
 * is a subsequence of
 * [
 * A
 * ,
 * B
 * ,
 * C
 * ,
 * D
 * ,
 * E
 * ,
 * F
 * ]
 * obtained after removal of elements
 * [
 * C
 * ,
 * E
 * ,
 * F
 * ]
 * . The relation of one sequence being the subsequence of another is a preorder.
 * <p>
 * There is an array
 * A
 * consisting of
 * N
 * integers. Tourist challenges Petr to solve a problem for all possible non-empty subsequences of this array. As we all know that an array of size
 * N
 * can have
 * (
 * 2
 * N
 * −
 * 1
 * )
 * number of non empty subsequences. Tourist thought that it would be difficult for him to check Petr output for all possible subsequences so he designed a technique to check Petr output. Tourist asked Petr to give him just the value of
 * b
 * i
 * t
 * w
 * i
 * s
 * e
 * <p>
 * O
 * R
 * of all the answers obtained after solving each subsequence.
 * <p>
 * There is a function
 * D
 * i
 * v
 * i
 * s
 * o
 * r
 * s
 * which is defined as below:
 * <p>
 * Divisors(long long int subsequence[])
 * {
 * int count[];//array initialised to 0.
 * for(i=0;i<subsequence.length;i++)
 * {
 * number=subsequence[i];
 * for(j=2;j<=number;j++)
 * {
 * if(number%j==0)
 * {
 * count[j]++;
 * if(count[j]==subsequence.length)
 * return 0;
 * }
 * }
 * }
 * return 1;
 * }
 * All the
 * (
 * 2
 * N
 * −
 * 1
 * )
 * subsequences are passed in the function
 * s
 * o
 * l
 * v
 * e
 * :
 * <p>
 * solve(long long int subsequence[])
 * {
 * return Divisors(subsequence);
 * }
 * Petr asks for your help to compute the
 * b
 * i
 * t
 * w
 * i
 * s
 * e
 * <p>
 * O
 * R
 * of all the answers generated from every subsequence.
 * <p>
 * Input Format
 * <p>
 * First line contains
 * T
 * testcases.
 * <p>
 * Then
 * T
 * lines follow each containing a value
 * N
 * (size of array).
 * <p>
 * Then
 * N
 * integers containing the array elements.
 * <p>
 * Constraints
 * <p>
 * 1
 * <p>
 * ≤
 * <p>
 * T
 * <p>
 * ≤
 * <p>
 * 10000
 * 1
 * <p>
 * ≤
 * <p>
 * N
 * <p>
 * ≤
 * <p>
 * 100
 * 1
 * <p>
 * ≤
 * <p>
 * A
 * [
 * i
 * ]
 * <p>
 * ≤
 * <p>
 * 10
 * 9
 * Output Format
 * <p>
 * Print
 * T
 * lines containing the answer
 * <p>
 * Sample Input 0
 * <p>
 * 1
 * 2
 * 2 3
 * <p>
 * Sample Output 0
 * <p>
 * 1
 * <p>
 * Explanation 0
 * <p>
 * D
 * i
 * v
 * i
 * s
 * o
 * r
 * s
 * (
 * 2
 * )
 * =
 * 0
 * <p>
 * D
 * i
 * v
 * i
 * s
 * o
 * r
 * s
 * (
 * 3
 * )
 * =
 * 0
 * <p>
 * D
 * i
 * v
 * i
 * s
 * o
 * r
 * s
 * (
 * 2
 * ,
 * 3
 * )
 * =
 * 1
 * <p>
 * 0
 * <p>
 * O
 * R
 * <p>
 * 0
 * <p>
 * O
 * R
 * <p>
 * 1
 * =
 * 1
 * <p>
 * Example
 * Input
 * 1
 * 2
 * 2 3
 * Output
 * 1
 */
public class HardestProblemEver {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputlong = br.readLine();

        int t = Integer.parseInt(inputlong);

        while (t > 0) {

            String inputN = br.readLine(); // Read the size of the array
            int n = Integer.parseInt(inputN);

            long[] a = new long[n];

            String[] elements = br.readLine().split(" "); // Read the array elements as a string and split

            for (int i = 0; i < n; i++) {

                a[i] = Long.parseLong(elements[i]); // Parse and store each element

            }

            if (n == 1) {

                System.out.println(0);

            } else {

                long gc = gcd(a[0], a[1]);

                for (int i = 2; i < n; i++) {

                    gc = gcd(gc, a[i]);

                }

                if (gc == 1) {
                    System.out.println("1");
                } else {
                    System.out.println(0);
                }
            }

            t--;

        }

    }


    public static long gcd(long a, long b) {

        long maxm = Math.max(a, b);

        long minm = Math.min(a, b);

        while (maxm % minm != 0) {

            long tmp = maxm;

            maxm = minm;

            minm = tmp % minm;


        }

        return minm;

    }
}
