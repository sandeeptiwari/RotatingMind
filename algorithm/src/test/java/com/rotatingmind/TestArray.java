package com.rotatingmind;

import com.rotatingmind.array.IntersectionOfTwoArray;
import com.rotatingmind.array.MostFrequentlyOccurElement;
import com.rotatingmind.string.NonRepeatingChar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArray {


    @Test
    public void testMostFrequentItem() {
        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};

        int [] arr = {1, 4, 4, 4, 4, 4, 4, -2, 4, 7, 4, 0, 5, 5, 5, 5, 5, 5,5};

        MostFrequentlyOccurElement obj = new MostFrequentlyOccurElement();
        int mostFrequentElement = obj.getMostFrequent(array1);
        assertEquals(1, mostFrequentElement);

        int mostFrequentElement1 = obj.getMostFrequent(array2);
        assertEquals(3, mostFrequentElement1);

        Integer mostFrequentElement2 = obj.getMostFrequent(array3);
        assertNull(mostFrequentElement2);

        Integer mostFrequentElement3 = obj.getMostFrequent(array4);
        assertEquals(0, mostFrequentElement3);

        Integer mostFrequentElement4 = obj.getMostFrequent(array5);
        assertEquals(-1, mostFrequentElement4);
    }


    @Test
    public void testIntersection() {
        int[] array1 = {1, 3, 4, 6, 7, 9};
        // mostFrequent(array2) should return 3.
        int[] array2 = {1, 2, 4, 5, 9, 10};

        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        // commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).

        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
        // common_elements(array1C, array2C) should return [] (an empty array).


        int results[] = {1, 4, 9};
        int result2[] = {1, 2, 9, 10, 12};

        IntersectionOfTwoArray obj = new IntersectionOfTwoArray();
        int ele[] = obj.intersection(array1, array2);

        int ele2[] = obj.intersection(array1B, array2B);

        int ele3[] = obj.intersection(array1C, array2C);

        int ele4[] = {};

        assertArrayEquals(results, ele);

        assertArrayEquals(result2, ele2);

        assertArrayEquals(ele4, ele3);
    }

    @Test
    public void testNonRepeatingChar() {
        NonRepeatingChar obj = new NonRepeatingChar();
        //Character aabcb = obj.nonRepeating("aabcb");
       // assertEquals('c', aabcb);

       // Character xy = obj.nonRepeating("xxyz");
        //assertEquals('y', xy);

       // assertEquals('c', obj.nonRepeating("abcab")); // should return 'c'
       // assertEquals(null, obj.nonRepeating("abab")); // should return null
       // assertEquals('c', obj.nonRepeating("aabbbc")); // should return 'c'
        assertEquals('d', obj.nonRepeating("aabbdbc")); // should return 'd'
    }
}
