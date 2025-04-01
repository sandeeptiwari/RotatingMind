package com.rottaingmind.ds.dp.practice;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
 *
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 *
 * Input: nums = [3,4,2]
 * Output: 6
 * Explanation: You can perform the following operations:
 * - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
 * - Delete 2 to earn 2 points. nums = [].
 * You earn a total of 6 points.
 *
 * Input: nums = [2,2,3,3,3,4]
 * Output: 9
 * Explanation: You can perform the following operations:
 * - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
 * - Delete a 3 again to earn 3 points. nums = [3].
 * - Delete a 3 once more to earn 3 points. nums = [].
 * You earn a total of 9 points.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> frequency = new HashMap<>();
        int earn1 = 0, earn2 = 0;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            frequency.compute(nums[i], (k, v) ->  v == null ? 1 : ++v);
        }

        for (int i = 0; i < n; i++) {

            int currentEarn = nums[i] * frequency.getOrDefault(nums[i], 1);

            if (i > 0 && nums[i] == nums[i-1] + 1) {
                int temp = earn2;
                earn2 = Math.max(currentEarn + earn1, earn2);
                earn1 = temp;
            } else {
                int temp = earn2;
                earn2 = currentEarn + earn2;
                earn1 = temp;
            }
        }

        return earn2;
    }

    public int deleteAndEarn(int[] nums, int n) {
        int a[]=new int[10001];
        for(int i:nums)
        {
            a[i]+=i;
        }
        int dp[]=new int[10001];
        dp[0]=a[0];
        dp[1]=Math.max(a[0],a[1]);
        for(int i=2;i<=10000;i++)
        {
            dp[i]=Math.max(dp[i-2]+a[i] , dp[i-1]);
        }
        return dp[10000];
    }
}
