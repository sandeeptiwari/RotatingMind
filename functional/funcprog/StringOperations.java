package com.sandi.funcprog;

public class StringOperations {

	public static void main(String[] args) {
		final String str = "w00t";
		
		//str.chars().forEach(ch -> System.out.println(ch));
		
		//str.chars().forEach(System.out::println);
		
		//str.chars().forEach(StringOperations::printChar);
		
		
		/*If we want to process characters and not int from the start, we can convert
		the ints to characters right after the call to the chars() method, like so:*/
		
		/*str.chars()
			.mapToObj(ch-> Character.valueOf((char)ch))
			.forEach(System.out::println);*/
		
		
		/*we can filter out only digits from the
		string, like so:*/
		
		str.chars()
		   .filter(ch -> Character.isDigit((char)ch))
		   .forEach(System.out::println);
		
		//print exact values
		System.out.println("Print real values");
		
		str.chars()
			.filter(ch -> Character.isDigit((char)ch))
			.mapToObj(ch -> Character.valueOf((char)ch))
			.forEach(System.out::println);
		
	}
	
	private static void printChar(int aChar) {
		System.out.println((char)(aChar));
		}

}
