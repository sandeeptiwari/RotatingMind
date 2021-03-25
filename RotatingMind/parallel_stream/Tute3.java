package com.sandi.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Tute3 {
	
	public static void transform() {
		System.out.println(Thread.currentThread());
		
		
	}  
	
	public static void main(String...args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		numbers.stream()
		       .parallel()
		       .forEach(System.out::println);
		
		
		ForkJoinPool pool = ForkJoinPool.commonPool();
		System.out.println(pool);
		
	}

}
