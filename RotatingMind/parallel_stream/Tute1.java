package com.sandi.async;

import java.util.Arrays;
import java.util.List;

public class Tute1 {

	public static void main(String[] args) {

		//elegance in the absence of efficience is no good
		// java just not gave elegance, it gave us elegance
		// with efficiency by lazy function
		
		 List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		 
		 System.out.println(
				 numbers.stream()
				        .parallel()
				        .filter(e -> e%2 == 0)
				        .mapToInt(e -> e *2)
				        .sum());

	}

}
