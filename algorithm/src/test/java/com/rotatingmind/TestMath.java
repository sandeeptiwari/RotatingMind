package com.rotatingmind;

import com.rotatingmind.math.LCMTest;
import com.rotatingmind.math.MathOperations;
import com.rotatingmind.math.ModuloOperationDemo;
import com.rotatingmind.math.PrimeNumber;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class TestMath {

    @Test
    public void shouldReturnFactOfGivenNumber() {
        MathOperations ops = new MathOperations();
        double fact = ops.fact(12);
        assertEquals(479001600, fact);
    }

    @Test
    public void shouldReturnTrueIfNumberIsPalindrome() {
        MathOperations ops = new MathOperations();
        boolean isPalindrome = ops.isNumberPalindrome(121);
        boolean isPalindrome1 = ops.isNumberPalindrome(125);
        boolean isPalindrome2 = ops.isNumberPalindrome(913319);
        assertTrue(isPalindrome);
        assertFalse(isPalindrome1);
        assertTrue(isPalindrome2);
    }

    @Test
    public void shouldReturnPowerResultOfNumber() {
        ModuloOperationDemo ops = new ModuloOperationDemo();
        int fastPow = ops.getFastPow(5, 3);
        assertEquals(125, fastPow);
    }

    @Test
    public void testLCM() {
        LCMTest obj = new LCMTest();
        int lcm = obj.lcm(4, 6);
        assertEquals(12, lcm);
    }

    @Test
    public void testIsPrime() {
        PrimeNumber obj = new PrimeNumber();
        boolean isPrime = obj.isPrimeNumber(7);
        assertTrue(isPrime);
    }
}
