package java24.utils;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

class State<T> {
    T maxElement;
}

public class MaxByGatherer<T, B extends Comparable<B>> implements Gatherer<T, State<T>, T> {
    private final Function<T, B> extractor;

    MaxByGatherer(Function<T, B> extractor) {
        this.extractor = extractor;
    }

    @Override
    public Supplier<State<T>> initializer() {
        return State::new;
    }

    @Override
    public Integrator<State<T>, T, T> integrator() {
        System.out.println("integrator runs1");
        return Integrator.ofGreedy((state, item, _) -> {
            if (state.maxElement == null) {
                state.maxElement = item;
                System.out.println("integrator runs2");
                return true;
            }

            B currentItemValue = extractor.apply(item);
            B maxItemValue = extractor.apply(state.maxElement);

            if (currentItemValue.compareTo(maxItemValue) > 0) {
                state.maxElement = item;
            }
            System.out.println("integrator runs3");
            return true;
        });
    }

    @Override
    public BinaryOperator<State<T>> combiner() {

        System.out.println("combiner runs");

        return (first, second) -> {
            if (first.maxElement == null && second.maxElement == null) {
                return null;
            } else if (first.maxElement == null) {
                return second;
            } else if (second.maxElement == null) {
                return first;
            }

            B firstMaxValue = extractor.apply(first.maxElement);
            B secondMaxValue = extractor.apply(second.maxElement);

            if (firstMaxValue.compareTo(secondMaxValue) > 0) {
                return first;
            } else {
                return second;
            }
        };
    }

    @Override
    public BiConsumer<State<T>, Downstream<? super T>> finisher() {
        return (state, downstream) -> downstream.push(state.maxElement);
    }
}
