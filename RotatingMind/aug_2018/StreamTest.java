package com.test.sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;;

public class StreamTest {

	public static void main(String[] args) {
		
		/*Stream<String> s = Stream.generate(() -> "meow");
		boolean match = s.allMatch(e -> e.isEmpty());
		
		System.out.println(match);*/
		
		List<Integer> l1 = Arrays.asList(1, 2, 3);
		List<Integer> l2 = Arrays.asList(4, 5, 6);
		List<Integer> l3 = Arrays.asList();
		
		Stream.of(l1, l2, l3)
			//.map(x -> x +1) it will not use for list > 2 stream
		    .flatMap(x -> x.stream())
		    .forEach(System.out::print);
	}

}
