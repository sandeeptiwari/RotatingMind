package com.rotatingmind;

import com.rotatingmind.math.DigitsInFactorial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitInFactorialTest {

    @Test
    public void testDigitsInFact() {
        DigitsInFactorial obj = new DigitsInFactorial();
        int i = obj.digitsInFactorial(5);
        assertEquals(3, i);
    }
}
