package com.rotatingmind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAbsNumber {

    @Test
    public void testAbs() {
        int a = -30;
        int b = (a <= 0) ? 0 - a : a;
        assertEquals(30, b);
    }
}
