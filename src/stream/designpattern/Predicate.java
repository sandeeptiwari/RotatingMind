package stream.designpattern;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        return (T t) -> this.test(t) &&
        other.test(t);
    }
}
