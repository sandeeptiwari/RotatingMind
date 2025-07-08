package com.rotatingmind.array.sorting;

public class SortColor75 {

    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while (j <= k) {

            if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
                j++;
            } else if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else {
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColor75 obj = new SortColor75();
        int[] a = new int[]{2,0,2,1,1,0};
        int[] a1 = new int[]{2,0,1};
        obj.sortColors(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
