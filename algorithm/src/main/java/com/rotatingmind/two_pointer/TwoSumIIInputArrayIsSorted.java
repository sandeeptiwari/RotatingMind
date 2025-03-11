package com.rotatingmind.two_pointer;

//167.
public class TwoSumIIInputArrayIsSorted {

    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] res = new int[2];

        for(int l = 0, r = n-1; l < r;) {

            int sum  = numbers[l] + numbers[r];

            if (target == sum) {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }

        }
        return new int[]{-1, -1};  // This should never happen as per problem constraints
    }

    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        int[] a1 = {2,3,4};
        //int[] res = twoSum(a, 9);//[0, 1]
        int[] res = twoSum(a1, 6);//[0, 2]
        System.out.println("Pairs with the two sum is: (" + res[0] + ", " + res[1] + ")");
    }
}
