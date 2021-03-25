package com.sandi.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DuplicateInArray {
	
	/*
	 * 1- Sort the array
	 * 2- scan array from 1 like
	 * java-7
	 */
	public int[] printRepeatingEle(int[] arr, int size) {
		int i, k = 0;
		int []a = new int[size/2];
		
		System.out.println(" Repeating elements are ");
		Arrays.sort(arr);
		for (i = 1; i < size; i++) {
			
			if(arr[i-1] == arr[i]) {
				a[k] = arr[i];
				k++;
			}
		}
		return a;
	}
	
	/*
	 * 1- Sort the array
	 * 2- scan array from 1 like
	 * java-7
	 */
	public Set<Integer> printRepeatingEleJava8(List<Integer> numbers) {
	//public List<Integer> printRepeatingEleJava8(List<Integer> numbers) {
		/* return numbers.stream()
					.sorted()
					.filter(e -> Collections.frequency(numbers, e) > 1)
					.collect(Collectors.toList());
		*/
		Set<Integer> duplicatedNumbersRemovedSet = new HashSet<>();
		Set<Integer> duplicatedNumbersSet = numbers.stream()
				                                   .filter(n -> duplicatedNumbersRemovedSet.add(n) == false)// element which is duplicate
												   .collect(Collectors.toSet());
		
		Set<Integer> duplicated = numbers.stream().filter(n -> numbers.stream().filter(x -> x == n).count() > 1).collect(Collectors.toSet());
		
		Map<Integer, Long> duplicates = numbers.stream()
                //.boxed()
                .collect( Collectors.groupingBy( c -> c, Collectors.counting() ) );
                /*.entrySet()
                .stream()
                .filter( p -> p.getValue() > 1 )
                .map( e -> e.getKey() )
                .collect( Collectors.toList() );*/
		
		System.out.println("Map => "+duplicates);
		
		//return duplicates;
		return duplicated;
		//return duplicatedNumbersSet;
	}
	
	/*
	 * 1- scan array and store into hashmap key will e array's element and value will be its occurance
	 * 
	 */

	public List<Integer>  fetchRepeatingEleUsingMap(List<Integer> numbers) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < numbers.size(); i++) {
			
			if(!map.containsKey(numbers.get(i))){
				map.put(numbers.get(i), 1);
			}else {
				result.add(numbers.get(i));
			}
		}
		
		return result;
	}
	
	//Remove duplicates from a List using Java 8 Lambdas
	
	public  List<Integer> givenListContainsDuplicatesWhenRemovingDuplicatesWithJava8ThenCorrect(List<Integer> numbers) {
	    return numbers.stream()
	    			  .distinct()
	                  .collect(Collectors.toList());
	}
		
}
