package com.rotatingmind.methods;

import com.rotatingmind.java8.comparator.Person;

import java.util.*;
import java.util.stream.Collectors;

public class PlayWithMapMethods {

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Brian", 56);
        Person p3 = new Person("Chelsea", 46);
        Person p4 = new Person("David", 28);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("John", 18);

        City newYork = new City("New York");
        City shanghai = new City("Shanghai");
        City paris = new City("Paris");

        Map<City, List<Person>> map = new HashMap<>();

        map.putIfAbsent(paris, new ArrayList<>());
        map.get(paris).add(p1);

        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
        map.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);


        Map<City, List<Person>> map2 = new HashMap<>();

        map.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
        map.computeIfAbsent(paris, city -> new ArrayList<>()).add(p5);
        map.computeIfAbsent(paris, city -> new ArrayList<>()).add(p6);


        System.out.println("People from Paris " + map.getOrDefault(paris, Collections.emptyList()));


        map2.forEach((city, people) -> {
            map.merge(city, people,
                    (peopleFromMap1, peopleFromMap2) -> {
                        peopleFromMap1.addAll(peopleFromMap2);
                        return peopleFromMap1;
                    });
        });
    }
}
