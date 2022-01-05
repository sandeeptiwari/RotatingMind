package com.rotatingmind.java8.stream.predicate;

public class PlayWithPredicate {

    public static void main(String[] args) {

        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> s.isEmpty();
        Predicate<String> notP2 = p2.negate();

        Predicate<String> p3 = p1.and(notP2);
        System.out.println("Test " + p3.test("Sandeep"));
    }
}
