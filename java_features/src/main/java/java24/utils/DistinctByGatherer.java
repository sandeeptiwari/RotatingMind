package java24.utils;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Gatherer;




public class DistinctByGatherer<T, P> implements Gatherer<T, Set<P>, T> {

    private final Function<T, P> selector;

    public DistinctByGatherer(Function<T, P> selector) {
        this.selector = selector;
    }

    @Override
    public Supplier<Set<P>> initializer() {
        return HashSet::new;
    }

    @Override
    public Integrator<Set<P>, T, T> integrator() {
        return Integrator.of(((state, element, downstream) -> {
            P extracted = selector.apply(element);

            if (!state.contains(extracted)) {
                state.add(extracted);
                downstream.push(element);
            }
            return true;
        }));
    }

    @Override
    public BinaryOperator<Set<P>> combiner() {
        System.out.println("I am the combiner");
        return Gatherer.super.combiner();
    }

    @Override
    public BiConsumer<Set<P>, Downstream<? super T>> finisher() {
        System.out.println("I am the finisher");
        return Gatherer.super.finisher();
    }

    @Override
    public <RR> Gatherer<T, ?, RR> andThen(Gatherer<? super T, ?, ? extends RR> that) {
        System.out.println("I am the andThen");
        return Gatherer.super.andThen(that);
    }




}

