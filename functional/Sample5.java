package com.sandi.sample1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sample5 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
		
		//double the even values and put that into a list
		
		//wrong way
		List<Integer> doubleOfEven = new ArrayList<>();
		
		numbers.stream()
		.filter(e -> e % 2 == 0)
		.map(e -> e *2)
		.forEach(e -> doubleOfEven.add(e));
		
		//mutability is OK, sharing is nice, shared mutability is devils work
		
		
		System.out.println(doubleOfEven);//don' t do this
		
		
		//right approach
		List<Integer> doubleOfEven2 
				= numbers.stream()
						 .filter(e -> e % 2 == 0)
						 .map(e -> e * 2)
						 .collect(Collectors.toList());
		
		System.out.println(doubleOfEven2);
		
		
	}

}
