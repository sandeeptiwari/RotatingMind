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
 *
 * Intuition
 * Intuition aprroach is return the addition directly by coverting it into num1.parseInt()
 * and num2.parseInt() and then add but this will fail for the case in Long Int value as
 * you don't know which value is coming in the String it is only int or a long value.
 *
 * Approach
 * Take each char from the end of num1 and num2 and add, and then append it in the string you
 * created.
 *
 * Confusion
 *
 * charAt(i)-'0'
 *
 * Beginner might get confused why I have used .charAt(i)-'0'. It is used to get the integer
 * value at that particular i value of the string you can try this in your local IDE with '0'
 * and without '0' .charAt(i) of the String you will get some other value's might be the
 * ascii value, but with using '0' you will get the exact int value at that particular point.
 */
public class AddString {




    public static void main(String[] args) {
        BiFunction<String, String, String> addFunc = getStringStringStringBiFunction();
        //System.out.println(addFunc.apply("6913259244", "71103343"));//6984362587
       // String sumOfString = addStrings("456", "77");
       // System.out.println(sumOfString);//533
        //String sumOfString1 = addStrings("11", "123");//"134"
        //System.out.println(sumOfString1);

        //String sumOfString2 = addStrings("0", "0");
        System.out.println(addFunc.apply("456", "77"));//0
    }

    private static BiFunction<String, String, String> getStringStringStringBiFunction() {
        Map<Integer, Integer> intAsciiMap = new HashMap<>();
        int start = 48;
        for(int i = 0; i <= 9; i ++) {
            intAsciiMap.put(start + i, i);
        }
        AddString addString = new AddString();
        BiFunction<String, String, String> addFunc =
                (num1, num2) -> {
                    int len1 = num1.length() - 1;
                    int len2 = num2.length() - 1;
                    int sum = 0, carryOver = 0;
                    StringBuilder result = new StringBuilder();
                    while (len1 >= 0 || len2 >= 0) {
                        var x = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
                        var y = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
                        sum = x + y + carryOver;
                        carryOver = sum / 10;
                        int val = sum % 10;
                        result.append(val);
                        len1--;
                        len2--;
                    }

                    if (carryOver > 0) {
                        result.append(carryOver);
                    }
                    return String.valueOf(result.reverse());
                };
        return addFunc;
    }

    public static String addStrings(String num1, String num2) {
        int carry=0;
        StringBuilder result = new StringBuilder();
        int i=num1.length() -1;
        int j=num2.length() -1;

        while (i >= 0 && j >= 0) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';

            int sum = n1 + n2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        if (i >= 0 || j >= 0) {
            String greaterStr = num1.length() > num2.length()? num1 : num2;
            int startVal = greaterStr.charAt(Math.max(i, j)) - '0';
            result.append(startVal + carry);
        }

        return result.reverse().toString();
    }

    public String addStrings1(String num1, String num2) {
        String sb = new String();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int cry = 0;
        while(i >= 0 || j >= 0)
        {
            if(i >= 0)
                cry += (int)(num1.charAt(i--) - '0');
            if(j >= 0)
                cry += (int)(num2.charAt(j--) - '0');
            int digit = cry%10;
            sb = digit + "" + sb;
            cry/= 10;
        }
        return (cry == 0)? sb : cry + "" + sb;
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
