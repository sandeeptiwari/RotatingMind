package com.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

interface EvenTester{
	
	boolean isEven();
}

public class GeneralTest {

	public static void show() {
		List<Integer> numbers = Arrays.asList(1, 1, 4, 8, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> numbers1 = Arrays.asList(2, 4, 6, 8, 10, 12, 14);
		
		/* Case -1 :: */
		 numbers.stream()
				.distinct().forEach(num -> {
					System.out.print(num);// print distinct number 1 4 8 2 3 5 6 7 9
				});
		
		/* Case - 2 ::
		 * Returns an {@link Optional} describing the first element of this stream,
	     * or an empty */
		Optional<Integer> op = numbers.stream().findFirst();
		
		System.out.println(op.get());//1
		
		
		/*Case - 3 ::*/
		Predicate<Integer> predicate = e->(e%2==0);
		boolean isEven = numbers1.stream().allMatch(predicate);
		System.out.println("IsEven ==> "+isEven);
	}
	
	public static void main(String[] args) {
		show();
	}

}
