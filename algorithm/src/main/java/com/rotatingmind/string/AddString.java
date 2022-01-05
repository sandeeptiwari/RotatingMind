package com.rotatingmind.string;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Result String should not have leading zeros.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 *
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 */
public class AddString {


    private void seedMap() {

    }

    public static void main(String[] args) {
        Map<Integer, Integer> intAsciiMap = new HashMap<>();
        int start = 48;
        for(int i = 0; i <= 9; i ++) {
            intAsciiMap.put(start + i, i);
        }
        AddString addString = new AddString();
        addString.seedMap();
        BiFunction<String, String, String> addFunc =
                (num1, num2) -> {
                    int len1 = num1.length() - 1;
                    int len2 = num2.length() - 1;
                    int sum = 0, carryOver = 0;
                    StringBuilder result = new StringBuilder();
                    while (len1 >= 0 || len2 >= 0) {
                        var x = len1 >= 0 ? intAsciiMap.get((int)num1.charAt(len1)) : 0;
                        var y = len2 >= 0 ? intAsciiMap.get((int)num2.charAt(len2)) : 0;
                        sum = x + y + carryOver;
                        carryOver = sum / 10;
                        int val = sum % 10;
                        result = new StringBuilder(String.valueOf(val)).append(result);
                        len1--;
                        len2--;
                    }

                    if (carryOver > 0) {
                        result =  new StringBuilder(String.valueOf(carryOver)).append(result);
                    }
                    return String.valueOf(result);
                };

        System.out.println(addFunc.apply("6913259244", "71103343"));//6984362587
    }

    public String sum(String num1, String num2) {
        return null;//getNumber(num1).add(getNumber(num2)).toString();
    }

    /*private BigInteger getNumber(String num) {
        int len = num.length();
        BigInteger result = BigInteger.ZERO;
        for(int i = 0; i <= len-1; i++) {
            BigInteger val = new BigInteger(String.valueOf(intAsciiMap.get((int) num.charAt(i)) * Math.pow(10, len - (i + 1))));
            result = result.add(val);
        }
        return result;
    }*/


}
