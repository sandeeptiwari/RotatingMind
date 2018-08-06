package com.sandi.sample1;

import java.util.Arrays;
import java.util.List;

public class Sample8 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
		
		numbers.stream()
		       .filter(e -> e%2 == 0)
		       .forEach(System.out::println);
		//sized, orderd, non-distinct, non-sorted
		
		numbers.stream()
	       .filter(e -> e%2 == 0)
	       .sorted()
	       .forEach(System.out::println);
	  //sized, orderd, non-distinct, sorted
		
		
		numbers.stream()
	       .filter(e -> e%2 == 0)
	       .sorted()
	       .distinct()
	       .forEach(System.out::println);
	  //sized, orderd, distinct, sorted
		
		numbers.stream()
	       .filter(e -> e%2 == 0)
	       .sorted()
	       .distinct()
	       .forEach(System.out::println);
	  //sized, orderd, distinct, sorted
		
		
	}

}
