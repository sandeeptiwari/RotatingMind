package com.rotatingmind.array;

public class FrequencyOfArrayElement {


    //if arr is sorted
    public void printFrequency(int[] nums) {
        int len = nums.length;
        int i = 1; int freq = 1;

        while (i < len) {
            while (i < len && nums[i] == nums[i -1]) {
                freq++;
                i++;
            }
            System.out.println(nums[i - 1] + " " + freq);
            freq = 1;
            i++;
        }

    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 5, 5, 8, 8, 8, 8, 8, 9, 9, 9, 9};
        FrequencyOfArrayElement frequencyOfArrayElement = new FrequencyOfArrayElement();
        frequencyOfArrayElement.printFrequency(nums);
    }
}
