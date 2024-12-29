package com.rotatingmind.array.sorting;

import java.util.Arrays;

/**
 * Naive T.C : O(n^2) and we want to improve this
 *
 *
 *
 * one thing we can do is sort the array so that we won't have to check which elements are larger than the current element
 *
 * because in a sorted array all elements toward the right side are greater or equal to the current element.
 *
 *
 *
 * e.g :
 *
 * array =                        1 2 3 4 4 5 6
 *
 * original index =      6 1 5 4 3 0 2
 *
 *
 *
 * let's say we are at 2 now to maximise (j-i) we want all the element on the right side which has largest original index
 *
 * we are not considering left side elements as they are smaller (we sorted the array);
 *
 *
 *
 * Problem reduces to finding largest original index on the right side of current element efficiently
 *
 * we can do this naively but that would result in O(n^2) T.C overall.
 *
 * we can do this by making use of suffix max
 *
 *
 *
 * how? we traverse from back and keep track of maximum value of original index we have seen so far
 *
 * this way we will only be traversing the array once
 *
 * and at each index we can check what is the largest value towards its right side using suffix max variable
 *
 *
 *
 *
 *
 * array =                        1 2 3 4 4 5 6
 *
 * original index =      6 1 5 4 3 0 2
 *
 * suffix max =             6 5 5 4 3 2 2
 */
public class MaximizedIndexDiff {

    static class Pair{

        int x;
        int index;
        Pair(int a, int b){
            this.x=a;
            this.index=b;
        }

    }
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int A[], int n) {
        Pair arr[]=new Pair[n];
        for(int i=0;i<n;i++){
            arr[i]=new Pair(A[i],i);
        }

        Arrays.sort(arr, (a, b)->{return a.x-b.x;});
        // Your code here
        // int suffixMax[]=new int [n];
        int suff=arr[n-1].index;
        int diff=0;
        int ans=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            ans=Math.max(ans, suff-arr[i].index);
            suff=Math.max(suff, arr[i].index);
        }

        // int diff=0;
        // for(int i=0;i<n;i++){
        //     diff=Math.max(suffixMax[i]-arr[i].index,diff);
        // }
        return ans<0?0:ans;

    }
}
