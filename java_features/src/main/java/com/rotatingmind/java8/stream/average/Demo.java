package com.rotatingmind.java8.stream.average;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;


public class Demo {

    public static void main(String[] args) {
        example1();
    }

    public static void example1() {
        List<Integer> number= asList(1, 2, 3, 100, 23, 93, 99);

        Integer num= number.stream().max(Comparator.naturalOrder()).get();
        System.out.println(num);
    }
}
