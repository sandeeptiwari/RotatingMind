package com.rottaingmind.application.trappingwater;

import com.rottaingmind.ds.stack.applications.trappingwater.TrappingRainWater;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrappingWaterTest {
    private TrappingRainWater trappingRainWater;

    @BeforeEach
    public void setUp() {
        trappingRainWater = new TrappingRainWater();
    }

    @Test
    public void testTrappingWater() {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        assertTrue(trappingRainWater.getTrappingWater(height) == 6);
    }

    @Test
    public void testTrappingWaterWithZeroSizeArray() {
        int height[] = {};
        assertTrue(trappingRainWater.getTrappingWater(height) == 0);
    }
}
