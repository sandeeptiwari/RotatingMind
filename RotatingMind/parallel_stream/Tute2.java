package com.sandi.async;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//https://www.youtube.com/watch?v=IwJ-SCfXoAU
public class Tute2 {

	public static int transform(int number) {
		System.out.println("transform: "+number +" "+Thread.currentThread());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public void workWithStream(Stream<Integer> stream, boolean runParallel) {
		//stream.parallel()// when you are not auther of stream only receiving stream
		     // .map()
		
	}
	public static void main(String[] args) {
	  List<Integer> numbers =  Arrays.asList(1, 2, 3);
	  
	 /* numbers.stream()
	         .map(Tute2 :: transform)
	         .forEach(System.out :: println);
	  */
	  //convert into parallel
	 /* numbers.parallelStream()// when you are auther of stram
	         .map(Tute2 :: transform)
	         .forEach(System.out :: println);*/
	  
	  
	  List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	  
	  list.stream()
	  	  .parallel()
	  	  .map(Tute2::transform)
	  	  .forEachOrdered(System.out::println);
	  
	  //REDUCE
	  
	  list.stream()
	  	  .parallel()//don't do this
	      .reduce(0,  Integer::sum);
	}

}
