package com.rotatingmind;


import com.rotatingmind.array.RotateArrayByK;
import com.rotatingmind.math.ConsecutiveSumOfNumber;
import com.rotatingmind.math.Groups;
import com.rotatingmind.array.LargestElementInArray;
import com.rotatingmind.array.NonRepeatingNumber;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldReturnMaxElementOfArray() {
        int arr[] = {1, 99, 1000, 121, 2, 2, 3, 7};
        LargestElementInArray obj = new LargestElementInArray();
        assertTrue(obj.largest(arr) == 1000);
    }

    @Test
    public void shouldReturnNthTermOfProgression() {
        ConsecutiveSumOfNumber consecutiveSumOfNumber = new ConsecutiveSumOfNumber();
        double nthTerm = consecutiveSumOfNumber.getNthTerm(21, 10);
        assertEquals(2, nthTerm);
    }


    @Test
    public void shouldReturnConsecutiveList() {
        ConsecutiveSumOfNumber consecutiveSumOfNumber = new ConsecutiveSumOfNumber();
        List<Groups> numberOfConsecutiveGroup = consecutiveSumOfNumber.getNumberOfConsecutiveGroup(10);
        assertEquals(1, numberOfConsecutiveGroup.size());
    }


    @Test
    public void shouldReturnCombination() {
        ConsecutiveSumOfNumber consecutiveSumOfNumber = new ConsecutiveSumOfNumber();
        int[] arr = consecutiveSumOfNumber.getMostConsecutiveSeq(40);
        int a[] = {6, 7, 8, 9, 10};
        assertArrayEquals(a, arr);
    }

    @Test
    public void check() {
        int N = 21;
        int ans = 0;
        for (int n = 2; n * (n + 1) / 2 <= N; ++n) {
            if ((N - n * (n + 1) / 2) % n == 0) {
                ans++;
            }
        }

        System.out.println("ANS " + ans);
    }


    @Test
    public void testPerfectSquare() {
        App app = new App();
        boolean powerOfTwo = app.isPowerOfTwo(16777217);
        assertTrue(powerOfTwo == false);
    }

    @Test
    public void TestNonRepeatingNumber() {
        int arr[] = {2, 4, 7, 9, 2, 4, 9};
        NonRepeatingNumber obj = new NonRepeatingNumber();
        int singleOccurrenceNumber = obj.getSingleOccurrenceNumber(arr);
        assertEquals(7, singleOccurrenceNumber);
    }

    @Test
    public void TestTwoNonRepeatingNumber() {
        int arr[] = {6, 8, 9, 12, 13, 0, 1, 6, 8, 9, 12, 13};
        NonRepeatingNumber obj = new NonRepeatingNumber();
        int singleOccurrenceTwoNumber[] = obj.getSingleOccurrenceTwoNumber(arr);
        int [] results = {1, 0};
        assertArrayEquals(results, singleOccurrenceTwoNumber);
    }

    @Test
    public void TestFindRightMost() {
        NonRepeatingNumber obj = new NonRepeatingNumber();
        int setRightMostBit = obj.findRightMostSetBit(14);
        assertEquals(2, setRightMostBit);
    }

    @Test
    public void TestSetBitByPosition() {
        NonRepeatingNumber obj = new NonRepeatingNumber();
        boolean isSetBit = obj.isSetBitAtPosition(14,2);
        assertTrue(isSetBit);
    }

    @Test
    public void testIsRotation() {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2a = {4, 5, 6, 7, 8, 1, 2, 3};
        // isRotation(array1, array2a) should return false.
        int[] array2b = {4, 5, 6, 7, 1, 2, 3};
        // isRotation(array1, array2b) should return true.
        int[] array2c = {4, 5, 6, 9, 1, 2, 3};
        // isRotation(array1, array2c) should return false.
        int[] array2d = {4, 6, 5, 7, 1, 2, 3};
        // isRotation(array1, array2d) should return false.
        int[] array2e = {4, 5, 6, 7, 0, 2, 3};
        // isRotation(array1, array2e) should return false.
        int[] array2f = {1, 2, 3, 4, 5, 6, 7};
        // isRotation(array1, array2f) should return true.

        RotateArrayByK obj = new RotateArrayByK();
        boolean rotation = obj.isRotation(array1, array2a);
        assertFalse(rotation);

        boolean rotation1 = obj.isRotation(array1, array2b);
        assertTrue(rotation1);

        boolean rotation2 = obj.isRotation(array1, array2c);
        assertFalse(rotation2);

        boolean rotation3 = obj.isRotation(array1, array2f);
        assertFalse(rotation3);
    }

    @Test
    public void twoSumToGivenNumber() {
        int[] a = {1, 2, 4, 4};
        int target = 8;
        int n = a.length;
        int i = 0;
        int j = n -1;

        while (i < j) {
            int sum = a[i] + a[j];

            if (sum == target) {
                System.out.println("Found i " + i + " j  " + j);
                break;
            } else if (a[i] + a[j] < target) {
                i++;
            } else {
                j--;
            }
        }
    }

    @Test
    public void twoSumToGivenNumberV1() {
        Map<Integer, Integer> map = new HashMap<>();
        int[] a = {1, 2, 7, 3, 4, 2, 5};
        int target = 8;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int complement = target - a[i];

            if (map.get(complement) != null) {
                System.out.println("Found i " + i + " j  " + map.get(complement));
                break;
            }
            map.put(a[i], i);
        }
    }
}
