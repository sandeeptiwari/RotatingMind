package com.rotatingmind.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode3375 {

    public int minOperations(int[] nums, int k) {

        boolean allEleEqualToK = Arrays.stream(nums).allMatch(ele -> ele == k);

        if (allEleEqualToK) {
            return 0;
        }

        boolean isAllEleGreaterOrEqualToK = Arrays.stream(nums).allMatch(ele -> ele >= k);

        if (!isAllEleGreaterOrEqualToK) {
            return -1;
        }

        int allEleGreaterThanK = (int)Arrays.stream(nums).distinct().filter(ele -> ele > k).count();


        return allEleGreaterThanK == 0 ? -1 : allEleGreaterThanK;

    }

    public int minOperations1(int[] nums, int k) {
        boolean[] has = new boolean[101];

        for (int num : nums) {
            has[num] = true;
        }
        int cnt = 0;
        for (int i = 0; i < has.length; i++) {
            if (!has[i]) continue;

            if (has[i] && i < k)
                return -1;
            else if (has[i] && i > k)
                cnt++;
        }
        return cnt;
    }

    public int optimizedCheck2(int[] nums, int k) {
        boolean allEqualToK = true;
        boolean allGreaterOrEqualToK = true;
        Set<Integer> greaterThanK = new HashSet<>();

        for (int num : nums) {
            if (num != k) {
                allEqualToK = false;
            }
            if (num < k) {
                allGreaterOrEqualToK = false;
            }
            if (num > k) {
                greaterThanK.add(num);
            }
        }

        if (allEqualToK) return 0;
        if (!allGreaterOrEqualToK) return -1;

        return greaterThanK.isEmpty() ? -1 : greaterThanK.size();
    }

    public int minOperations4(int[] nums, int k) {

        Set<Integer> resultSet = new HashSet<>();
        boolean allEleEqualToK = true; // 0

        for (int num : nums) {

            if (num < k) {
                return -1;
            }

            if (num != k) {
                allEleEqualToK = false;
            }

            if (num > k) {
                resultSet.add(num);
            }
        }

        if (allEleEqualToK) return 0;


        return resultSet.size() == 0 ? -1 : resultSet.size();

    }
}
