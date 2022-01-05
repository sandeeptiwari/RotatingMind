package com.rotatingmind.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsecutiveSumOfNumber {

    /**
     * Consecutive Sum =  (i -1).j + j.(j+1)/2
     * where j = total number in progression;
     *       i = first term of progression
     * @param args
     */
    public static void main(String[] args) {
        ConsecutiveSumOfNumber obj = new ConsecutiveSumOfNumber();
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases >= 1) {
            int N = sc.nextInt();
            int[] arr = obj.getMostConsecutiveSeq(N);
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                System.out.print(arr[i] + " ");
            }
            cases--;
        }

    }

    /**
     *
     * @param num
     * @return
     */
    public List<Groups> getAllPossibleCombination(int num) {
        List<Groups> groups = new ArrayList<>();
        for (int i = 1, j=1; i < num - 1; j++) {
            int value = getConsecutiveSum(i, j);
            if(value == 21) {
                Groups group = new Groups();
                group.setFirstTerm(i);
                group.setNumberOfTerms(j - i);
                i++;
                j = i;
                groups.add(group);
            } else if(j >= num) {
                i++;
                j = i;
            }
        }
        return groups;
    }

    public int getConsecutiveSum(int firstNum, int n) {
        return (firstNum - 1) * n + n * (n + 1) / 2;
    }

    public double getNthTerm(int sum, int a) {
        double b = (a << 1) - 1;
        double ac = sum << 1;
        double twoTimeFirstTerm = a << 1;
        double rootValue = Math.sqrt(b * b + 4 * ac);
        Double value1 =  (-b + rootValue) / twoTimeFirstTerm;
        Double value2 =  (-b - rootValue) / twoTimeFirstTerm;
        return Math.abs(value1) % 1 == 0 ? Math.abs(value1.intValue()) : Math.abs(value2.intValue());
    }

    public List<Groups> getNumberOfConsecutiveGroup(int N) {
        List<Groups> groups = new ArrayList<>();
        int n = 1;
        int a = N << 1;
        while(a - (n * n) + n > 0) {
            int twiceOfn = n << 1;
            float firstTerm = (a - (n * n) + n) / (float)twiceOfn;
            if(firstTerm % 1 == 0 && firstTerm != N) {
                Groups group = new Groups();
                group.setFirstTerm((int)firstTerm);
                group.setNumberOfTerms(n);
                groups.add(group);
            }
            n++;
        }
        return groups;
    }

    public int[] getMostConsecutiveSeq(int N) {
        int n = 1;
        int sum = N << 1;
        List<int[]> combinations = new ArrayList<>();
        while((sum - (n * n) + n) > 0) {
            int arr[] = new int[2];
            int a = n << 1;
            float firstTerm = (sum - (n * n) + n) / (float)a;
            if (firstTerm % 1 == 0 && firstTerm != N) {
                if(combinations.size() == 0) {
                    arr[0] = (int)firstTerm;
                    arr[1] = n;
                } else if (combinations.get(0)[1] < n){
                    arr[0] = (int)firstTerm;
                    arr[1] = n;
                }
                combinations.add(0, arr);
            }
            n++;
        }

        int first = combinations.get(0)[0];
        int len = combinations.get(0)[1] + first;
        int a[] = new int[combinations.get(0)[1]];
        for(int i = first, j = 0; i < len; i++) {
            a[j++] = i;
        }
        return a;
    }
}
