package com.sandi.sample1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sample6 {

	public static List<Person> createPeople(){
		return Arrays.asList(
				new Person("Sara", Gender.FEMALE, 20),
				new Person("Sara", Gender.FEMALE, 22),
				new Person("Bob", Gender.MALE, 20),
				new Person("Paula", Gender.FEMALE, 32),
				new Person("Paul", Gender.MALE, 32),
				new Person("Jack", Gender.MALE, 2),
				new Person("Jack", Gender.MALE, 72),
				new Person("Jill", Gender.FEMALE, 12)
				);
	}
	
	public static void main(String[] args) {
		List<Person> people = createPeople();
		
		//create a Map with name and age as key, and the person as value
		
		/*people.stream()
			  .collect(Collectors.toMap(
					  person -> person.getName()+"-"+person.getAge(),
					  person -> person  ));*/
		
		// give a list  of people, create a map where
		//their name is the key and value is all the people with that name.
		
		//Before Java 8
		Map<String, List<Person>> map= new HashMap<>();
		
		for (Person person : people) {
			
			if(!map.containsKey(person.getName())) {
				List<Person> pList = new ArrayList<>();
				pList.add(person);
				
				map.put(person.getName(), pList);
			}else {
				List<Person> pList = map.get(person.getName());
				pList.add(person);
				map.put(person.getName(), pList);
			}
			
		}
		
		
		//from java - 8
	    Map<String, List<Person>> map2 =	people.stream()
				      .collect(Collectors.groupingBy(Person :: getName));
	    
	    //given a list of people, create a map where
	    //their name is the key and value is all the ages of people with that name
	    System.out.println(
	    people.stream()
	    	  .collect(Collectors.groupingBy(Person :: getName,
	    			  Collectors.mapping(Person :: getAge, Collectors.toList()))));
		/*
		 * Output :
		 * {Bob=[20], sara=[20. 22], Jill=[12], Jack=[2, 27], Paula=[32], Paul=[32] }		
		 */
				
	}

}
