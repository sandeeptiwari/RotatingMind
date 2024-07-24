package com.rotatingmind.array.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Frequency Of the most frequent element description


public class SolveTheEquation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // PICKING UP LHS SIDE
        // a * b + c

        Map<Integer, Integer> LHSMap = new HashMap<>();

        int val, fq;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                for (int k = 0; k < N; k++) {

                    val = arr[i] * arr[j] + arr[k];

                    fq = LHSMap.getOrDefault(val, 0);

                    fq++;

                    LHSMap.put(val, fq);

                }

            }
        }

        // PICKING UP LHS SIDE

        // d * (e+f)

        HashMap<Integer, Integer> RHSMap = new HashMap<>();

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                for (int k = 0; k < N; k++) {

                    val = arr[i] * (arr[j] + arr[k]);

                    fq = RHSMap.getOrDefault(val, 0);

                    fq++;

                    RHSMap.put(val, fq);

                }
            }
        }

        int countAllSixTouples = 0;

        for (Integer key : LHSMap.keySet()) {
            if (RHSMap.get(key) != null)
                countAllSixTouples += LHSMap.get(key) * RHSMap.get(key);
        }

        System.out.println(countAllSixTouples);

    }
}
