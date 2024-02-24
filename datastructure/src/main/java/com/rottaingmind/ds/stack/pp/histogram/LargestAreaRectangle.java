package com.rottaingmind.ds.stack.pp.histogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestAreaRectangle {
    public static int maxArea(int[] heights) {
        int maxAra = Integer.MIN_VALUE;
        int len = heights.length;
        int[] nse = new int[len];
        int[] pse = new int[len];
        Deque<Integer> st = new ArrayDeque<>();

        st.push(0);

        for (int i = 1; i < len; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                nse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            nse[st.peek()] = len;
            st.pop();
        }

        st.push(len - 1);

        for (int i = len-2; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                pse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            pse[st.peek()] = len;
            st.pop();
        }

        for (int i = 0; i < len; i++) {
            int width = nse[i] - pse[i] - 1;
            maxAra = Math.max(maxAra, (width * heights[i]));
        }

        return maxAra;
    }


    public static void main(String[] args) {
        int[] heights = {6, 2, 5, 4, 5, 1, 6};
        int area = maxArea(heights);
        System.out.println("Area = " + area);
    }
}
