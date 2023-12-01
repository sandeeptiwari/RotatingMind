package com.rotatingmind.array;




public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
       int len = nums.length;
       int l = 1;
       int r = 1;
       int ans = nums[0];

        for (int i = 0; i < len; i++) {

            //if any of l or r become 0 then update it to 1
            l = l==0 ? 1 : l;
            r = r==0 ? 1 : r;

            l *= nums[i];   //prefix product
            r *= nums[len-1-i];    //suffix product


            ans = Math.max(ans, Math.max(l, r));

        }
      return ans;
    }

    public int maxProductV1(int[] nums) {

        int max = nums[0], min = nums[0], ans = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {

            // Swapping min and max
            if (nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }



            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);


            ans = Math.max(ans, max);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        int prodSum = maxProduct(arr);
        System.out.println("Max Product Sum :: " + prodSum);
    }
}
