package com.sandi.funcprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ComperatorSample {

	public static void main(String[] args) {
		
		final List<Person> peoples = Arrays.asList(
				new Person("John", 20),
				new Person("Sara", 21),
				new Person("Jane", 21),
				new Person("Greg", 35));
		
		List<Person> personSortedByAge = peoples.stream()
		       .sorted((person1, person2) -> person1.ageDifference(person2))
		       .collect(Collectors.toList());
		
		List<Person> personSortedByAge1 = peoples.stream()
			       .sorted(Person::ageDifference)
			       .collect(Collectors.toList());
		
		printPeople("Sorted in ascending order by age: ", personSortedByAge1);
		
		
		List<Person> personSortedByAge2 = peoples.stream()
			       .sorted((person1, person2) -> person2.ageDifference(person1))
			       .collect(Collectors.toList());
		
		printPeople("Sorted in descending order by age: ", personSortedByAge2);
		
		
		Comparator<Person> compareAscending =
				(person1, person2) -> person1.ageDifference(person2);
				
	   Comparator<Person> compareDescending =	
			   					compareAscending.reversed();
		
	   printPeople("Sorted in ascending order by age: ", 
			   			peoples.stream()
			   				   .sorted(compareAscending)
			   				   .collect(Collectors.toList()));
	   
	   
	   printPeople("Sorted in descending order by age: ", 
	   			peoples.stream()
	   				   .sorted(compareDescending)
	   				   .collect(Collectors.toList()));
	   
	   printPeople("Sorted in ascending order by name:", 
			   		peoples.stream()
			   		       .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
			   		       .collect(Collectors.toList()));
	   
	   System.out.println("pick the youngest person in the list");
	   
	   peoples.stream()
	   	      .min(Person::ageDifference)
	   	      .ifPresent(System.out::println);
	   
	   
	   System.out.println("By using comparing");
	   
	   final Function<Person, Integer> byAge = person -> person.getAge();
	   final Function<Person, Integer> byName = person -> person.getAge();
	   List<Person> sortedList = peoples.stream()
	          .sorted(Comparator.comparing(byAge)
	          .thenComparing(byName))
	          .collect(Collectors.toList());
	   printPeople("Sorted in ascending order by age and name:", sortedList);
	   
	   
	   System.out.println("Collect only people older than 20 years from the list\n");
	   
	   final List<Person> olderThan20 = new ArrayList<>();
	   peoples.stream()
	   		  .filter(person -> person.getAge() >= 21)
	   		  .forEach(person -> olderThan20.add(person));
	   
	   printPeople("Result ::", olderThan20);
	   
	   System.out.println("Collect only people older than 20 years from the list, By second way\n");
	   final List<Person> olderThan20New =
			   	peoples.stream()
			   	       .filter(person -> person.getAge() >= 21)
			   	       //.collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
			   	       .collect(Collectors.toList());
	   
	   printPeople("Result New ::", olderThan20New);
	   
	   
	   System.out.println("Group Person By their Age");
	   
	   Map<Integer, List<Person>> peopleByAge 
	   							= peoples.stream()
	   							         //.collect(Collectors.groupingBy(person -> person.getAge()));
	   							.collect(Collectors.groupingBy(Person::getAge));
	   System.out.println(peopleByAge);
	   
	   
	   System.out.println("Group person by their age and name");
	   
	   Map<Integer, List<String>> peopleByAgeAndName 
			= peoples.stream()
			         .collect(Collectors.groupingBy(Person::getAge, 
			        		 Collectors.mapping(Person::getName, Collectors.toList())));
	   System.out.println(peopleByAgeAndName);
	   
	   
	   System.out.println("let’s group the names by their first character\n");
	   
	   Comparator<Person> byAgeComp = Comparator.comparing(Person::getAge);
	   
	   Map<Character, Optional<Person>> oldestPersonOfEachLetter =
			   peoples.stream()
			   .collect(Collectors.groupingBy(person -> person.getName().charAt(0),
			   Collectors.reducing(BinaryOperator.maxBy(byAgeComp))));
	   
	   System.out.println(oldestPersonOfEachLetter);
	}

	private static void printPeople(String msg, List<Person> personSortedByAge) {
		System.out.println(msg);
		personSortedByAge.stream()
		                 .forEach(System.out::println);
	}
	
	

}
