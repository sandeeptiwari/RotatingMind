package com.sandi.sample1;

import java.util.Arrays;
import java.util.List;

public class Sample3 {

	public static void main(String...args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		//given the values, double the even number and total.
		
		/*System.out.println(numbers.stream()
		.filter( num -> num %2 == 0)
		.map( num -> num *2 )
		.reduce(0, Integer::sum));*/
		
		//function compansation : pipeline 
		//Note : never put two . in same line
		System.out.println(numbers.stream()
				.filter( num -> num %2 == 0)
				.mapToInt( num -> num *2 )
				.sum());
	}
}
