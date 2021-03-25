package stream.designpattern;

import stream.designpattern.model.Person;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {

   int compare(T t1, T t2);

   /*
    static <T> Comparator<T> comparing(Function<T, String> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (p1, p2) -> {
            String name1 = keyExtractor.apply(p1);
            String name2 = keyExtractor.apply(p2);
            return name1.compareTo(name2);
        };
    }
    */

    static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (p1, p2) -> {
            U s1 = keyExtractor.apply(p1);
            U s2 = keyExtractor.apply(p2);
            return s1.compareTo(s2);
        };
    }

   default Comparator<T> reversed() {
        return (t1, t2) -> this.compare(t2, t1);
   }

    default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        Comparator<T> other = comparing(keyExtractor);
        return this.thenComparing(other);
    }

    default Comparator<T> thenComparing(Comparator<T> other) {
        Objects.requireNonNull(other);
        return (t1, t2) -> {
            int compare = this.compare(t1, t2);

            if (compare == 0) {
                return other.compare(t1, t2);
            } else {
                return compare;
            }
        };
    }
}
