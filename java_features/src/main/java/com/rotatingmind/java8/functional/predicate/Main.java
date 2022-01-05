package com.rotatingmind.java8.functional.predicate;

public class Main {

    public static void main(String[] args) {
        Predicate<String> p = s -> s.length() < 20;
        System.out.println(p.test("Welcome"));
    }
}
