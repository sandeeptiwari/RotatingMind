package com.rotatingmind.java16;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMulti {

    public static void main(String[] args) {
        testMultiMap();
    }

    public static void testMultiMap() {
       /* List<Integer> evenNumbers = Stream.of(1, 2, 3, 4).flatMap(number -> {

            if ((number & 1) == 0) {
                return Stream.of(number, number);
            } else {
                return Stream.of();
            }
        }).collect(Collectors.toList());

        System.out.println(evenNumbers);*/

        List<Integer> evenNumbers = Stream.of(1, 2, 3, 4)
                .<Integer>mapMulti((number, downStream) -> {
                    if((number & 1) == 0) {
                        downStream.accept(number);
                        downStream.accept(number);
                    }
                }).toList();
        System.out.println(evenNumbers);
    }
}
