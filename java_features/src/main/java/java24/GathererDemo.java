package java24;

import java24.utils.MyGatherers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

public class GathererDemo {

    <E> Gatherer<E, ?, E> limit(long limit) {
        class Box {
            long counter = 0L;
        }
        Supplier<Box> initializer = Box::new;
        Gatherer.Integrator<Box, E, E> integrator =
                (box, element, downstream) -> {
                    if (downstream.isRejecting()) {
                        return false;
                    } else if (box.counter < limit) {
                        box.counter++;
                        return downstream.push(element);
                    } else {
                        return false;
                    }
                };
        Gatherer<E, ?, E> gatherer = Gatherer.ofSequential(initializer, integrator);
        return gatherer;
    }

    <E> Gatherer<E, ?, E> distinct() {
        Supplier<HashSet<E>> initializer = HashSet::new;
        Gatherer.Integrator<HashSet<E>, E, E> integrator =
                (set, element, downstream) -> {
                    if (set.add(element)) {
                        return downstream.push(element);
                    } else {
                        return false;
                    }
                };
        Gatherer<E, ?, E> gatherer = Gatherer.ofSequential(initializer, integrator);
        return gatherer;
    }


    private static final Currency EUR = Currency.getInstance("EUR");
    private static final Currency PLN = Currency.getInstance("PLN");

    public static void main(String[] args) {
        GathererDemo obj = new GathererDemo();
        /*var result = Stream.of(1, 2, 3, 4, 5)
                .gather(obj.limit(3))
                .toList();
        System.out.println("result = " + result);*/


        /*var result = Stream.of(1, 2, 3, 4, 5, 4, 3, 2, 1)
                .gather(obj.distinct())
                .toList();
        System.out.println("result = " + result);*/

       /* var result = Stream.of("a,b", "c,d", "e")
                .collect(Gatherers.flatMap(s -> Arrays.stream(s.split(","))))
                .toList();

        System.out.println(result);*/

        maxDemo();


    }

    private static void maxDemo() {
        var money = List.of(
                new Money(BigDecimal.valueOf(12), PLN),
                new Money(BigDecimal.valueOf(11), PLN),
                new Money(BigDecimal.valueOf(15), PLN)
        );

        System.out.println("\nMax By Amount");
        money.stream()
                .parallel()
                .gather(MyGatherers.maxBy(Money::amount))
                .forEach(System.out::println);
    }

    private static void reduceDemo() {
        var money = List.of(
                new Money(BigDecimal.valueOf(12), PLN),
                new Money(BigDecimal.valueOf(11), EUR),
                new Money(BigDecimal.valueOf(15), PLN)
        );

        System.out.println("Reduce By Currency");
        money.stream()
                .gather(MyGatherers.reduceBy(Money::currency, Money::add))
                .forEach(System.out::println);
    }

    public static void demo1() {
        var money = List.of(
                new Money(BigDecimal.valueOf(12), PLN),
                new Money(BigDecimal.valueOf(11), EUR),
                new Money(BigDecimal.valueOf(15), PLN)
        );

        System.out.println("\nDistinct By Currency:");


        List<Money> result = money.stream().gather(MyGatherers.distinctBy(Money::currency)).toList();
        System.out.println(result);
    }
}
