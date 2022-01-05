package com.rotatingmind.java8.stream;

import java.util.Comparator;
import java.util.List;

public class MaxMinAndAverageDemo {

    public static void main(String[] args) {
        List<Integer> items = List.of(5, 9, 1, 11, 6, 90, 13);
        System.out.println("Max -> " + items.stream().max(Comparator.comparingInt(a -> a)));
    }
}
