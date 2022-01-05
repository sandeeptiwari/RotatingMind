package com.rotatingmind.java8.stream.collector;

import com.models.Person;
import com.util.MockData;

import java.io.IOException;
import java.util.ArrayList;

public class Demo1 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> res = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(
                        ArrayList::new, //supplier
                        ArrayList::add, // accumulator -> BiConsumer
                        ArrayList::addAll // BiConsumer -> combiner
                );
        //.collect(Collectors.toList())
        System.out.println("result " + res);
    }
}
