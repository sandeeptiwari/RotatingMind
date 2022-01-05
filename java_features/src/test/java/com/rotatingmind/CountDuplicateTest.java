package com.rotatingmind;

import com.rotatingmind.java_coding.CountDuplicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountDuplicateTest {

    private CountDuplicate countDuplicate;

    @BeforeEach
    private void setUp() {
        countDuplicate = new CountDuplicate();
    }

    @Test
    public void should_return_map_with_key_and_its_count() {
        Map<Character, Long> result
                = countDuplicate.countDuplicateCharacters("Sandeep Kumar Tiwari");

        assertEquals(2, result.get('e'));
        assertEquals(3, result.get('a'));
    }
}
