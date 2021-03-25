package com.test.sample;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchTest {

	public static void main(String[] args) {
		
		Comparator<Integer> cmptr = (o1, o2) -> o2 - o1;
		
		List<Integer> list = Arrays.asList(5, 4, 7, 1);
		
		//Collections.sort(list, cmptr);
		
		System.out.println("Without comperator"+Collections.binarySearch(list, 1));//undefined
		
		System.out.println("With comperator "+Collections.binarySearch(list, 1, cmptr));//3
		
		int mid = (1 + 10) >>> 1;
		System.out.println(mid);

	}

}
