package com.rotatingmind;

import com.rotatingmind.java_coding.FirstNonRepeatingCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstNonRepeatingCharacterTest {

    private FirstNonRepeatingCharacter firstNonRepeatingCharacter;

    @BeforeEach
    private void setUp() {
        firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
    }

    @Test
    public void should_return_first_non_repeating_character() {
        Character notRepeatingChar = firstNonRepeatingCharacter.getFirstNonRepeatingChar("naman");
        assertEquals('m', notRepeatingChar);
    }
}
