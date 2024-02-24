package com.rotatingmind.math;

import java.util.ArrayList;
import java.util.List;

public class NextSmallestPalindrome {

    public static int nextPalindrome(int n) {
        List<Integer> digits = new ArrayList<>();
        int num = n;

        // Reverse the digits and store in ArrayList
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }

        // Handle single-digit numbers
        if (digits.size() == 1) {
            return n + 1;
        }

        int mid = digits.size() / 2;
        boolean leftGreater = false;

        // Check if left half is greater than reversed right half
        for (int i = 0; i < mid; i++) {
            if (digits.get(i) > digits.get(digits.size() - 1 - i)) {
                leftGreater = true;
                break;
            } else if (digits.get(i) < digits.get(digits.size() - 1 - i)) {
                break;
            }
        }

        // If left half is greater, increment the middle digit and propagate carry
        if (leftGreater) {
            int carry = 1;
            int i = mid - 1;
            while (i >= 0 && carry > 0) {
                int sum = digits.get(i) + carry;
                digits.set(i, sum % 10);
                digits.set(digits.size() - 1 - i, sum % 10);
                carry = sum / 10;
                i--;
            }

            // If carry is still present, add a digit to the front
            if (carry > 0) {
                digits.add(0, 1);
            }
        }

        // Mirror the left half to the right half
        for (int i = mid; i < digits.size(); i++) {
            digits.set(digits.size() - 1 - i, digits.get(i));
        }

        // Convert ArrayList back to integer
        int result = 0;
        for (int digit : digits) {
            result = result * 10 + digit;
        }

        return result;
    }

    public static void main(String[] args) {
        int n =  2001; // Change this to test different inputs
        //1002
        int nextPalindrome = nextPalindrome(n);
        System.out.println("Next smallest palindrome for " + n + " is: " + nextPalindrome);
    }
}
