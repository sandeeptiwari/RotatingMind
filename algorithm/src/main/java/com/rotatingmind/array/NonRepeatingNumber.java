package com.rotatingmind.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NonRepeatingNumber {

    public int getSingleOccurrenceNumber(int arr[]) {
        return Arrays.stream(arr).reduce((a, b) -> a ^ b).getAsInt();
    }

    public int[] getSingleOccurrenceTwoNumber(int arr[]) {
        int value = Arrays.stream(arr).reduce((a, b) -> a ^ b).getAsInt();
        int rightMostSetBit = findRightMostSetBit(value);
        List<Integer> allNumberWithSetBitAtSamePos =
                Arrays.stream(arr)
                        .filter(ele -> isSetBitAtPosition(ele, rightMostSetBit))
                        .boxed()
                        .collect(Collectors.toList());

        List<Integer> allNumberWithNotSetBitAtSamePos =
                Arrays.stream(arr)
                        .filter(ele -> !isSetBitAtPosition(ele, rightMostSetBit))
                        .boxed()
                        .collect(Collectors.toList());
        int firstNum = allNumberWithSetBitAtSamePos.stream().reduce((a, b) -> a^b).get();
        int secondNum = allNumberWithNotSetBitAtSamePos.stream().reduce((a, b) -> a^b).get();
        int [] results = {firstNum, secondNum};
        return results;
    }


    public int findRightMostSetBit(int n) {

        // if n is odd return 1 because most right bit in odd number is 1
        if ((n & 1) != 0) {
            return 1;
        }

        // unset rightmost bit and xor with the number itself
        n = n ^ (n & (n - 1));

        // find the position of the only set bit in the result;
        // we can directly return `log2(n) + 1` from the function
        int pos = 0;

        while (n != 0) {
            n = n >> 1;
            pos++;
        }

        return pos;
    }

    public boolean isSetBitAtPosition(int num, int pos) {
        num = num & (1 << (pos - 1));
        return num != 0;
    }
}
