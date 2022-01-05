package com.rotatingmind.java8.stream.predicate;

import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> this.test(t) && other.test(t);
    }

    default Predicate<T> negate() {
        return (T t) -> !this.test(t);
    }

    static <U> Predicate<U> isEqualsTo(U u) {
        return s -> s.equals(u);
    }
}
