package com.rotatingmind.array;

import java.util.Arrays;
import java.util.Comparator;

public class MaxElement {

    public static void main(String[] args) {
        int [] a = {1, 5, 10, 45, 12, 35};
        System.out.println(getMax(a));
    }

    public static Integer getMax(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .max(Comparator.comparingInt(a -> a))
                .orElseThrow(() -> new NullPointerException("Not found"));
    }
}
