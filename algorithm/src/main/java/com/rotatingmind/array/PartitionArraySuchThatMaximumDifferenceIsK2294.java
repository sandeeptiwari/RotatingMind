package com.rotatingmind.array;


import java.util.Arrays;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

public class PartitionArraySuchThatMaximumDifferenceIsK2294 {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = n - 1;
        int count = 0;

        while(i <= j) {

            int diff = nums[j] - nums[i];

            if (diff > k) {
                j--;
            } else {
                count++;
                i = j + 1;
                j = n - 1;
            }

        }


        return count;
    }

    public static void main(String[] args) {
        PartitionArraySuchThatMaximumDifferenceIsK2294 obj  = new PartitionArraySuchThatMaximumDifferenceIsK2294();
        System.out.println(obj.partitionArray(new int[]{3,6,1,2,5}, 2));
        System.out.println(obj.partitionArray(new int[]{1,2,3}, 1));
        System.out.println(obj.partitionArray(new int[]{2,2,4,5}, 0));

        //Gatherer.ofSequential()
    }
}
