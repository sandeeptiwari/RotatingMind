package com.rotatingmind.methods;

import com.rotatingmind.java8.comparator.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayWithNewMethods {

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Brian", 56);
        Person p3 = new Person("Chelsea", 46);
        Person p4 = new Person("David", 28);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("John", 18);
        List<Person> persons = new ArrayList<>(List.of(p1, p2, p3, p4, p5, p6));

        persons.removeIf( p -> p.getAge() < 30);

        persons.replaceAll(p -> new Person(p.getName().toUpperCase(), p.getAge()));

        persons.sort(Comparator.comparing(Person::getAge));

        persons.forEach(System.out::println);
    }
}
