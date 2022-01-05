package com.rotatingmind.java8.comparator;

import com.rotatingmind.java8.stream.function.Function;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {

    /*
     * t1 > t2 : return > 1
     * t1 < t2 : return < -1
     * t1 == t2 : return 0
     */
    int compare(T t1, T t2);

    default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        Comparator<T> other = comparing(keyExtractor);
        return this.thenComparing(other);
    }

    default Comparator<T> thenComparing(Comparator<T> other) {
        Objects.requireNonNull(other);
        return (T t1, T t2) -> {
            int compare = this.compare(t1, t2);
            if (compare == 0) {
                return other.compare(t1, t2);
            } else {
                return compare;
            }
        };
    }

    default Comparator<T> reversed() {
        return (t1, t2) -> this.compare(t2, t1);
    }

    /*v1-> static <T> Comparator<T> comparing(Function<T, String> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (t1, t2) -> {
            String s1 = keyExtractor.apply(t1);
            String s2 = keyExtractor.apply(t2);
            return s1.compareTo(s2);
        };
    }*/
    //Comparable<? super U>>
    static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (t1, t2) -> {
            U u1 = keyExtractor.apply(t1);
            U u2 = keyExtractor.apply(t2);
            return u1.compareTo(u2);
        };
    }

    /**
     * Explaination:
     * Function return type is here Comparable because by that way we can
     * pass Integer/String OR any Comparable into Function
     * @param f
     * @return
     */
   /* static <U> Comparator<U> comparing(Function<U, Comparable> f) {
      //this return of-course implementation of comparator interface
        return (t1, t2) -> f.apply(t1).compareTo(f.apply(t2));
    }*/
}
