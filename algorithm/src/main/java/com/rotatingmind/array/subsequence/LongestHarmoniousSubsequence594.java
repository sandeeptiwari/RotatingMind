package com.rotatingmind.array.subsequence;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

record Pair(int num, int index){}

public class LongestHarmoniousSubsequence594 {

    public static int findLHS(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        List<Pair> pairs = IntStream.range(0, n)
                .mapToObj(index -> new Pair(nums[index], index))
                .toList();

        int maxHarmonious = 0;

        for(int i = 0, j = i + 1; i < n && j < n;){
            Pair currPair = pairs.get(i);
            while (j < n && pairs.get(j + 1).num() == pairs.get(j).num()) {
                j++;
            }
            i = j+1;
            Pair nextPair = pairs.get(j);
            if (nextPair.num() - currPair.num() == 1) {
                maxHarmonious = Math.max(maxHarmonious, Math.abs(nextPair.index() - currPair.index()) + 1);
            }
        }

        return maxHarmonious;
    }
  //1, 2, 2, 2, 3, 3, 5, 7
    public static void main(String[] args) {
        int [] a = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(a));
    }
}
