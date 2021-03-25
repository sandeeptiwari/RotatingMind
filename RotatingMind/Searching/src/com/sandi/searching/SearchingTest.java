package com.sandi.searching;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sandi.app.DuplicateInArray;

public class SearchingTest {

	private DuplicateInArray duplicateArray;
	
	@BeforeEach
	public void setUP() {
		duplicateArray = new DuplicateInArray();
	}
	
	
	@Test
	@DisplayName("Duplicate element using java 8")
	void testprintRepeatingEleJava8() {
		List<Integer> numbers = Arrays.asList(new Integer[]{1,2,1,3,4,4});
		Set<Integer> actuals = duplicateArray.printRepeatingEleJava8(numbers);
		Set<Integer> expecteds =  new HashSet<>(Arrays.asList(1, 4));
		
		//List<Integer> actuals = duplicateArray.printRepeatingEleJava8(numbers);
		//List<Integer> expecteds =  Arrays.asList(1, 4);
		
		assertEquals(expecteds, actuals);
	}
	
	@Test
	@DisplayName("Duplicate element using java 7")
	void testprintRepeatingEleJavat() {
		int []numbers =  {1,2,1,3,4,4};
		int[] actuals = duplicateArray.printRepeatingEle(numbers, numbers.length);
		int[] expecteds =  {1, 4, 0};
		
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	@DisplayName("Duplicate using hashmap")
	public void testFetchRepeatingEleUsingMap() {
		List<Integer> numbers = Arrays.asList(new Integer[]{1,2,1,3,4,4});
		List<Integer> actuals = duplicateArray.fetchRepeatingEleUsingMap(numbers);
		List<Integer> expecteds =  Arrays.asList(1, 4);
		
		assertEquals(expecteds, actuals);
	}
	
	
	@Test
	@DisplayName("Remove duplicate element in java 8")
	public void testGivenListContainsDuplicatesWhenRemovingDuplicatesWithJava8ThenCorrect() {
		
		List<Integer> numbers = Arrays.asList(new Integer[]{1,2,1,3,4,4});
		List<Integer> actuals = duplicateArray.givenListContainsDuplicatesWhenRemovingDuplicatesWithJava8ThenCorrect(numbers);
		List<Integer> expecteds =  Arrays.asList(1, 2, 3, 4);
		assertEquals(expecteds, actuals);
	}
}
