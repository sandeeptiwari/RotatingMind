package com.rotatingmind.java8.collectors;

import com.rotatingmind.java8.comparator.Person;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class PlayWithCollector {

    public static void main(String[] args) {
        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);

        List<Person> peoples = new ArrayList<>(List.of(mary, john, linda, james));

        Optional<Person> maxAgePeople = peoples.stream().max(Comparator.comparing(p -> p.getAge()));

        System.out.println(maxAgePeople.get());
    }

    public Map<Boolean, List<Person>> peopleByAge(List<Person> peoples) {
        return peoples.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() > 21));
    }

    /*public Map<Integer, TreeSet<String>> nameByAge(List<Person> peoples) {
        peoples.stream()
                .collect(
                        groupingBy(Person::getAge),
                        Collectors.mapping(
                                Person::getName,
                                Collectors.toCollection(TreeSet::new)
                        )
                );

    }*/


}
