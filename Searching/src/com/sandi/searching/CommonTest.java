package com.sandi.searching;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sandi.app.MaxOccurenceEleInArray;

public class CommonTest {
	
	private MaxOccurenceEleInArray obj;
	
	@BeforeEach
	public void setUP() {
		obj = new MaxOccurenceEleInArray();
	}
	
	@Test
	@DisplayName("Max repeating element in array")
	public void testMaxElement() {
		int arr[] = {1, 3, 4, 5, 6, 3, 4, 3, 9, 3};
		int actual = obj.findMaxRepeatingArrayEle(arr);
		int expected = 3;
		assertTrue(actual == expected);
	}
	
	@Test
	@DisplayName("Get Majority ele in array")
	public void testMajorityEle() {
		int []a = {1, 3, 3, 5, 3, 3, 4, 3, 9, 3};
		
		int actual = obj.getMajorityEleInArray(a);
		int expected = 3;
		
		assertTrue(actual == expected);
		
	}
	
	@Test
	@DisplayName("Doesn't occur twice in arra")
	public void testGetOccursOneEle() {
		int []a = {3, 4, 5, 3, 4};
		
		int actual = obj.getOccursOne(a);
		int expected = 5;
		
		assertTrue(actual == expected);
		
	}

}
