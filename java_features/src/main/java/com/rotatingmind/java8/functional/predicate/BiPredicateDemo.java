package com.rotatingmind.java8.functional.predicate;

import com.rotatingmind.java8.stream.consumer.Consumer;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BiPredicateDemo {

    public static void main(String[] args) {
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = str -> str.length() > 4;

        boolean sandeepTiwari = p2.test("Sandeep Tiwari");
       // System.out.println(sandeepTiwari);


        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Consumer<Integer> consumer = (v) -> {
          //  System.out.println(v);
        };
        consumer.accept(10);

        Function<Integer, String> function = (i) -> {
            return i.toString();
        };
        java.util.function.Predicate<Integer> isEven = (ele) -> ele % 2 == 0;
        //source over intermediate filter -> reduction, non
        List<String> result = list.stream()
               // .peek(ele -> System.out.println("Before -> " + ele))
                .filter(isEven)
               // .peek(ele -> System.out.println(ele))
                .map(function)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
