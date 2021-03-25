package com.sandi.funcprog;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Transform {

	public static void main(String[] args) {
		Folks.friends.stream()
					 .map(e -> e.toUpperCase());
					 //.forEach(System.out::println);
					 /*.forEach(new Consumer<String>() {

						@Override
						public void accept(String str) {
							System.out.println(str);
						}
					});*/
					 //.forEach(e -> System.out.println(e));
		
		
		
		/*final Function<String, Predicate<String>>
			startWithLetter = (String letter) -> (String name) -> name.startsWith(letter);*/
		
		/*final Function<String, Predicate<String>>
		startWithLetter = letter -> name -> name.startsWith(letter);
		
		
		final long countFriendsSatrtWithN
				= Folks.friends.stream()  
				     .filter(startWithLetter.apply("N")).count();
		
		final long countFriendsSatrtWithB
		= Folks.friends.stream()  
		     .filter(startWithLetter.apply("B")).count();
				     
		System.out.println(countFriendsSatrtWithN);
		System.out.println(countFriendsSatrtWithB);*/
		
		
		//find longest length of name
		//return optional
		/*Optional<String> optionalValue = Folks.friends.stream()
			         .reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
		
		optionalValue.ifPresent(name -> System.out.println(String.format("A longest name %s ", name)));
		
		//return <T>
		final String steveOrLonger =
				Folks.friends.stream()
				.reduce("Steve", (name1, name2) ->
				name1.length() >= name2.length() ? name1 : name2);*/
		
		System.out.println(String.join(", ", Folks.friends));
		
	}

}
