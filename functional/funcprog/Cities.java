package com.sandi.funcprog;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Cities {

	public static void main(String[] args) {
		List<String> cities = Arrays.asList("Albany", "Boulder", "Chicago", "Denver", "Eugene");
		
		/*System.out.println(cities.stream()
			  .filter(e -> e =="Delhi")
			  //.dropWhile(e -> e =="Chicago")
			  .findFirst()
			  .orElse(null));
		
	
				cities.stream()
				      .filter(e -> e == "Chicago")
				      .findFirst()
				      .ifPresent(new Consumer<String>() {

						@Override
						public void accept(String t) {
							System.out.println(t +" citi name is present in this list");
						}
					});*/
		
		/*System.out.println(cities.stream()
			  .map(String::toUpperCase)
		      .collect(Collectors.toList()));
*/
		
		MyClass myClass = new Cities().new MyClass();
		myClass.myField = "James";
		myClass.myMethod();
	}
	
	public static void pickName(final String startWith, List<String> names) {
		
		names.stream()
			 .filter(e -> e.startsWith(startWith));
			 
	}
	
	public void lexicalScope() {
		final Predicate<String> startsWithN = name -> name.startsWith("N");
	    final Predicate<String> startsWithB = name -> name.startsWith("B");
	    
	    final long countFriendsStartN = 
	      Folks.friends.stream()
	             .filter(startsWithN).count();         
	    final long countFriendsStartB = 
	    		Folks.friends.stream()
	             .filter(startsWithB).count();


	    System.out.println(countFriendsStartN);
	    System.out.println(countFriendsStartB);
	}
	
	class MyClass {
	    String myField = "you";
	    void myMethod() {
	        System.out.println("Hi " + myField);
	    }
	}
}



