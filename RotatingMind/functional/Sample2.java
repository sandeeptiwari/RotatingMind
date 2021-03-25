package com.sandi.sample1;

import java.util.Arrays;
import java.util.List;

public class Sample2 {
	
	public static void main(String...args) {
		
		//method refference with 2 parameter ::
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		//System.out.println(numbers.stream()
		//.reduce(0, (total, e) -> Integer.sum(total, e)));
		
		/*reduce takes two parameters, 1st for initialize values of both parameter and 
		second is lambda expression for summation of whole number.*/
		
		/*System.out.println(numbers.stream()
				//.reduce(0, (total, e) -> Integer.sum(total, e))
				.reduce(0, Integer::sum)// because not impact on order changing of parameter so here you can call method refernce
				);*/
		
		System.out.println(
		numbers.stream()
		.map(String::valueOf)
		//.reduce("", (carry, str) -> carry.concat(str))
		.reduce("", String::concat));  //in this case out of two parameter first one is target and second one is parameter, so here we can also call method reference
		
		
	}

}
