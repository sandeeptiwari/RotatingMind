package com.rotatingmind.array;

import java.util.Arrays;
import java.util.stream.Stream;

public class LargestElementInArray {

    public int largest(int[] arr) {
        return Arrays.stream(arr).reduce( (a, b) -> Math.max(a, b)).getAsInt();
    }
}
