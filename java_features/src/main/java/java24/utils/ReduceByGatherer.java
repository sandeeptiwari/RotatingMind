package java24.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Gatherer;

public class ReduceByGatherer<T, P> implements Gatherer<T, Map<P, T>, T> {
    private final Function<T, P> selector;
    private final BiFunction<T, T, T> operation;

    public ReduceByGatherer(Function<T, P> selector, BiFunction<T, T, T> operation) {
        this.selector = selector;
        this.operation = operation;
    }

    @Override
    public Supplier<Map<P, T>> initializer() {
        return HashMap::new;
    }

    @Override
    public Integrator<Map<P, T>, T, T> integrator() {
        return Integrator.ofGreedy(((state, element, downstream) -> {
            state.merge(selector.apply(element), element, operation);
            return true;
        }));
    }

    @Override
    public BinaryOperator<Map<P, T>> combiner() {
        System.out.println("combiner");
        return Gatherer.super.combiner();
    }

    @Override
    public BiConsumer<Map<P, T>, Downstream<? super T>> finisher() {
        System.out.println("finisher");
        return (state, downstream) -> state.values().forEach(downstream::push);
    }

    @Override
    public <RR> Gatherer<T, ?, RR> andThen(Gatherer<? super T, ?, ? extends RR> that) {
        return Gatherer.super.andThen(that);
    }
}
