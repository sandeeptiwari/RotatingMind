package com.rotatingmind.array.precompute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HeightsProblem {

   public int trapWater(int[] a) {
       int l = a.length;
       int[] prefixMax = new int[l];
       int[] suffixMax = new int[l];
       int totalHeights = Integer.MIN_VALUE;

       prefixMax[0] = a[0];
       suffixMax[0] = a[l-1];

       for (int i = 1; i < l; i++) {
           prefixMax[i] = Math.max(prefixMax[i-1], a[i]);
       }

       for (int i = l-1; i >= 0; i--) {
           suffixMax[i] = Math.max(suffixMax[i+1], a[i]);
       }

       for (int i = 1; i < l-1; i++) {

           int decH = Math.min(prefixMax[i-1], suffixMax[i + 1]);

           if(decH > a[i]) {
               totalHeights += (decH - a[i]);
           }
       }

       return totalHeights;
   }


    public static void main (String[] args)
    {
        /*

        if(n <=2) {
            return;
        }*/
        int[] height = {0, 1, 0, 2, 1, 3, 0, 2};;
        int n = height.length;

       /* for(int i = 0; i < n; i++) {
            //height[i] = sc.nextInt();
        }*/

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int trappedWater = 0;

        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            trappedWater += minHeight - height[i];
        }
        System.out.println("Res " + trappedWater);
    }


    public static void main () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int[] arr = new int[n];
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(str[i]);
            //Store at index i the max till index i-1
            maxLeft[i] = i>0? Math.max(maxLeft[i-1], arr[i-1]):0;
        }
        for(int i=n-1;i>=0;i--){
            //Store at index i the max till index i+1
            maxRight[i] = i<n-1? Math.max(maxRight[i+1], arr[i+1]):0;
        }
        //System.out.println(Arrays.toString(maxLeft));
        //System.out.println(Arrays.toString(maxRight));
        long rain = 0;
        for(int i=1;i<n-1;i++){
            int temp = Math.min(maxLeft[i], maxRight[i]);
            if(temp-arr[i]>0){
                rain = rain + temp-arr[i];
            }
        }
        System.out.println(rain);
    }

}
