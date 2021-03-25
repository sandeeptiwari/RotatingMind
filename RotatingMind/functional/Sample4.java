package com.sandi.sample1;

import java.util.Arrays;
import java.util.List;

public class Sample4 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
       Timeit.code( () ->   
		System.out.println(numbers.parallelStream()//.stream()
								  .filter(e -> e%2 == 0)
								  //.mapToInt(e -> compute(e))
								  .mapToInt(Sample4 :: compute)
								  .sum()));
		
		
	}
	
	public static int compute(int number) {
		//assume this is time intensive(time taking)
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return number * 2;
	}
	
	/*1:39
	 * map :: transform values -: number of output == number of input
	 * 1- no guarantee on the type of the output with respect to type of 
	 *    input
	 * 2- parameter : Stream<T> map takes Function<T, R> to return Stream<R>
	 * 3- both filter & map stay within their swimlane
	 * 4- reduce cut across the swimlane 
	 * 5- reduce on Stream<T> takes two parameter:
	 *    second parameter is of type BiFunction<R, T, R> to produce a result
	 *    of R
	 *    		1		2		   3			  4
	 *    		|		|		   |			  |
	 *    1 -> * -> 1 -> * -> 2 -> * -> * -> 6 -> * -> 24
	 *  Output of one step is input of other step.
	 *  
	 *      
	 */

}
