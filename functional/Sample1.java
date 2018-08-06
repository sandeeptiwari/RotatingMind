package com.sandi.sample1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//https://www.youtube.com/watch?v=1OpAgZvYXLQ
public class Sample1 {

	/*public static void main(String...args) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("In another thread");
			}

		});
		thread.start();

		System.out.println("In main Thread");
	}*/

	/*public static void main(String...args) {
		Thread thread = new Thread(() ->
				System.out.println("In another thread")//not create  new inner classes because of invokedynamic
			);
		thread.start();

		System.out.println("In main Thread");
	}*/

	public static void main(String...args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		//external iterator 1- 
		/*for (int index = 0; index < numbers.size(); index++) {
			System.out.println(numbers.get(index));

		}*/

		//external iterators also 2- 
		/*for (int e : numbers) {
			System.out.println(e);
		}*/

		//internal iterator

		/*numbers.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("Number :: "+t);
			}
		});*/

		/*Consumer<Integer> consumer = num -> System.out.println(num);
		numbers.forEach(consumer);*/

		//numbers.forEach((num)  -> System.out.println("Number :: "+num));
		// java 8 has type inference, finally, holds your tweets, but only 
		// for lambda expression   

		//numbers.forEach(System.out::println);

		//method refference with one parameter : Whenever you dont need to manipulate argument and just pass through
		// in that case only call method reference
		
		/*numbers.stream()
	 //.map(e -> String.valueOf(e))
	 .map(String::valueOf)
	 .forEach(System.out::println);*/

		/*numbers.stream()
		.map(e -> e.toString())
		//.map(e -> e.toString())
		.map(String::toString)
		.forEach(System.out::println);*/
		
		// method refference with 2 parameter ::
		
		// In sample-2
	}
}
