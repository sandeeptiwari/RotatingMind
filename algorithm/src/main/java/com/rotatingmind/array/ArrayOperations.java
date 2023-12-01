package com.rotatingmind.array;

import java.util.Arrays;

public class ArrayOperations {

    public void reverseArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start]  = nums[end];
        nums[end] = temp;
    }

    public void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


    public void moveAllZeroRightInArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] == 0) {
                swap(nums, start, end);
                end--;
            } else {
                start++;
            }
        }
    }

    public void moveAllZeroRightInArrayInJava8(int[] nums) {
        int[] result = Arrays.stream(nums)
                .filter(i -> i != 0)
                .toArray();
        System.out.println(Arrays.toString(result));
    }


    public void removeDuplicateElementFromArray(int[] nums) {
        //int[] nums = {1, 2, 3, 4, 5, 5, 6, 7, 8, 8};
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[res-1] != nums[i]) {
                nums[res] = nums[i];
                res++;
            }
        }
    }

    public void secondLargestElementInArray(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int num: nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }

        System.out.println("First: " + first + " Second: " + second);
    }

    public void moveZeroToLeft(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;

        while (l < r) {
            if (nums[l] == 0 && nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            } else if (nums[l] != 0) {
                l++;
            } else if (nums[r] == 0) {
                r--;
            }
        }
    }



    public static boolean isRotation(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        String str1 = Arrays.toString(arr1);
        String str2 = Arrays.toString(arr2);

        return str1.contains(str2);
    }

    public int maxProductInArray(int [] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int l = 1, r = 1;

        for (int i = 0; i < n; i++) {

            l = l == 0 ? 1 : l * nums[i];
            r = r == 0 ? 1 : r * nums[n - i - 1];

            max = Math.max(max, Math.max(l, r));
        }
        return max;
    }

   public void rotateArrayByD(int nums[], int d) {
        int n = nums.length;
        reverse(nums, 0, d - 1);
        reverse(nums, d, n - 1);
        reverse(nums, 0, n -1);
   }

   public void reverse(int[] nums, int start, int end) {
       while (start < end) {
           swap(nums, start, end);
           start++;
           end--;
       }
   }


   public void leaderInAnArray(int[] nums) {
        int n = nums.length;
        int currLeader = nums[0];
        System.out.println(currLeader);
       for (int i = 0; i < n; i++) {
           boolean flag = false;
           for (int j = i + 1; j < n; j++) {
               if (nums[i] <= nums[j]) {
                   flag = true;
                   break;
               }
           }
           if (flag) {
               System.out.println(nums[i]);
           }
       }
   }

    public void leaderInAnArrayV1(int[] nums) {
        int n = nums.length;
        int currLeader = nums[n - 1];
        System.out.println(currLeader);
        for (int i = n - 2; i >= 0; i--) {
            if (currLeader < nums[i]) {
                currLeader = nums[i];
                System.out.println(currLeader);
            }
        }
    }

    public void maxDiffV1(int[] nums) {
        int maxDiff = Integer.MIN_VALUE;
        int minVal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxDiff = Math.max(maxDiff, nums[i] - minVal);
            minVal = Math.min(minVal, nums[i]);
        }
    }
































    public void maxDiff(int[] nums) {
        int n = nums.length;
        int res = nums[1] - nums[0];
        int minVal = nums[0];

        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, nums[i] - minVal);
            minVal = Math.min(minVal, nums[i]);
        }
    }






    public static void main(String[] args) {
        ArrayOperations arrayOperations = new ArrayOperations();
        //int[] nums = {1, 2, 3, 4, 5};
       // arrayOperations.reverseArray(nums);

        //int[] nums = {1, 2, 3, 4, 5, 5, 6, 7, 8, 8};

        //int[] nums = {0, 1, 0, 3, 4,0, 6, 0, 2, 0,  5};
       // arrayOperations.moveZeroToLeft(nums);
       // arrayOperations.printArray(nums);

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 1, 2, 3};

       // boolean isRotation = isRotation(arr1, arr2);
        int[] nums = {2, 3, -2, 4};
        int result = arrayOperations.maxProductInArray(nums);
        System.out.println(result);
    }




}
