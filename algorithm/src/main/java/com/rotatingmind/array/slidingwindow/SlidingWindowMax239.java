package com.rotatingmind.array.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMax239 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] results = new int[n - k + 1];
        int maxInWindow = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            maxInWindow = Math.max(maxInWindow, nums[i]);
        }
        results[0] = maxInWindow;

        for (int i = k; i < n; i++) {
            maxInWindow = getMax(i - k + 1, i, nums);
            results[i - k + 1] = maxInWindow;
        }
        return results;
    }

    private int getMax(int start, int end, int[] nums) {
        int n = nums.length;
        int maxInWindow = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++) {
            maxInWindow = Math.max(maxInWindow, nums[i]);
        }

        return maxInWindow;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {

        int n = nums.length;
        int ptr = 0;
        int[] results = new int[n - k + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            insertAtLast(q, i, nums);
        }

        for (int i = k; i < n; i++) {
            results[ptr++] = nums[q.peek()];

            if (q.peek() == i - k) {
                q.pollFirst();
            }

            insertAtLast(q, i, nums);
        }

        results[ptr] = nums[q.peek()];

        return results;
    }

    private void insertAtLast(ArrayDeque<Integer> q, int i, int[] nums) {
        while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
            q.pollLast();
        }

        q.add(i);
    }

    public static void main(String[] args) {
        SlidingWindowMax239 obj = new SlidingWindowMax239();
        int[] nums = {1, -1};
        System.out.println(Arrays.toString(obj.maxSlidingWindow1(nums, 1)));
    }
}
