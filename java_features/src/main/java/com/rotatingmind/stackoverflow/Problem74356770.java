package com.rotatingmind.stackoverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Display all the numbers between 0 and 200 satisfying all the below conditions. Conditions:
 * i) Sum of the digits should be 9
 * ii) Digits should be in ascending order i.e.,
 * the digit on the left should be lesser than the digit in the right For Example: 27 -> 2+7=9
 * and 2 is less than 7 For Example: 135 -> 1+3+5=9 and 1 is less than 3 is less than 5
 */
public class Problem74356770 {

    private List<Integer> findAllElementsFromRange(int startPoint, int endPoint) {
        List<Integer> results = new ArrayList<>();
        results.add(9);
        IntStream.range(17, endPoint + 1)
                .forEach(ele -> {
                    Integer [] digits = findDigits(ele);
                    if(checkNumber(digits)) results.add(ele);
                });
        return results;
    }

    private boolean checkNumber(Integer[] digits) {
        if(digits[2] != null) {
            int sum = digits[0] + digits[1] + digits[2];
            if ((digits[0] >= digits[1] && digits[1] >= digits[2]) && sum == 9) {
                return true;
            }
        } else if (digits[0] >= digits[1]) {
            int sum = digits[0] + digits[1];
            if (sum == 9) return true;
        }
       return false;
    }

    private Integer [] findDigits(int ele) {
        Integer [] digits = new Integer[3];
        int i = 0;
        while (ele > 0) {
          int rem = ele % 10;
          digits[i] = rem;
          ele = ele/10;
          i++;
        }
        return digits;
    }

    public static void main(String[] args) {
        Problem74356770 obj = new Problem74356770();
        obj.findAllElementsFromRange(0, 200)
                .forEach(System.out::println);
    }
}
