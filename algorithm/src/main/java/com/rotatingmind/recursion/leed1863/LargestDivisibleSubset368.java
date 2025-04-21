package com.rotatingmind.recursion.leed1863;

import java.util.ArrayList;
import java.util.List;

public class LargestDivisibleSubset368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0, nums, result, temp, -1);
        return result;
    }


    private void solve(int idx, int [] nums, List<Integer> result, List<Integer> temp, int prevEle) {
        if (idx >= nums.length) {
            if (temp.size() > result.size()) {
                result.clear();
                result.addAll(temp);
                return;
            }
        }
        //take option
        if (prevEle == -1 || nums[idx] % prevEle == 0) {
            temp.add(nums[idx]);
            solve(idx + 1, nums, result, temp, nums[idx]);
            temp.remove(temp.size() - 1);
        }

        //not take
        solve(idx + 1, nums, result, temp, prevEle);
    }

    public static void main(String[] args) {
        LargestDivisibleSubset368 obj = new LargestDivisibleSubset368();
        //var list = obj.largestDivisibleSubset(new int[]{1,2,3});
        var list = obj.largestDivisibleSubset(new int[]{1});
        list.stream().forEach(System.out::println);
    }

}
