package com.rotatingmind.java8.functional.predicate;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
