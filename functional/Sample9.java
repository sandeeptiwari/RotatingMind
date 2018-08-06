package com.sandi.sample1;

import java.util.stream.Stream;

public class Sample9 {

	public static int comput(int k, int n) {
		int result = 0;
		int index = k;
		int count = 0;
		
		while(count < n) {
			if(index % 2 == 0 && Math.sqrt(index) > 20) {
				result += index * 2;
				count++;
			}
			index++;
		}
		
		return result;
		
		
	}
	
	
	public static int computNew(int k, int n) {
		return Stream.iterate(k, e -> e + 1)
				     .filter(e -> e%2 == 0)
				     .filter(e -> Math.sqrt(e) > 20)
				     .mapToInt(e -> e*2)
				     .limit(n)
				     .sum();
		
				
		
		
	}
	
	public static void main(String[] args) {
		
		//Stream.iterate(100, e -> e +1);//infinite stream
		
		/*
		 * start with 100, create a series
		 * 100, 101, 102, 103, 104, 105...
		 */
		
		//Given a number k, and a count n, find the double of n
		//even number starting with k, where sqrt of each number is > 20
		
		System.out.println("Result ::"+comput(1, 3));
	}

}
