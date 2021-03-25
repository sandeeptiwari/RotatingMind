package com.sandi.sample1;

import java.util.Arrays;
import java.util.List;

public class Sample7 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11, 12, 13, 14, 15, 16, 17, 18, 19, 20 );
	
		//given an order list find the double of the first even number greater that 3
		int result = 0;
		for (int e : numbers) {
			if(e > 3 & e % 2 == 0) {
				result = e * 2;
				break;
			}
		}
		System.out.println(result);
		
		//how much work - 8 unit work
		/*System.out.println(
		numbers.stream()
			   .filter(e -> e > 3)
		       .filter(e -> e % 2 == 0)
		       .map(e -> e * 2)
		       .findFirst());*/
		//how much work - 20 + 17 + 9 = 46
		
		//improvement
		
		System.out.println(
				numbers.stream()
					   .filter(Sample7 :: isGT3)
				       .filter(Sample7 :: isEven)
				       .map(Sample7 :: doubleIt)
				       .findFirst());
		       
	}
	
	public static boolean isGT3(int number) {
		return number > 3;
	}
	
	public static boolean isEven(int number) {
		return number %2 == 0;
	}
	
	public static int doubleIt(int number) {
		return number *2;
	}
	
	/*
	 * Streams are lazy evaluation in this case
	 * pick one element apply all pipeline function
	 * after that pick next
	 */

}
