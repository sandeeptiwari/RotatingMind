package ocp.expressions;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.lang.System;
import java.lang.*;
import java.util.Random;
import java.util.*;

public class SwitchDemo {


    public final static void main(final String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(10));
        //method3();
    }
   /* public static void main(String[] args) {

    }*/

    /**
     * First, this mess of code does compile. However, the source is an infinite stream.
     * The filter operation will check each element in turn to see whether any are not empty.
     * While nothing passes the filter, the code does not terminate. Therefore, option D is correct.
     */
    private static void method3() {
        Predicate<String> empty = String::isEmpty;
        Predicate<String> notEmpty = empty.negate();

        var result = Stream.generate(() -> "2")
                .peek(ele -> System.out.println("Element " + ele))
                .filter(notEmpty)
                .collect(Collectors.groupingBy(k -> k))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.partitioningBy(notEmpty));
        System.out.println(result);
    }
    private static void method2() {
        List<Integer> data = new ArrayList<>();
        IntStream.range(0, 100).parallel().forEachOrdered(data::add);
        System.out.println(data.size());
    }
    private static void method1() {
        final int score1 = 8, score2 = 3;
        char myScore = 7;

        var goal = switch (myScore) {
            //default -> {if (10 > score1) yield "unknown"; }
            case score1 -> "great";
            case 2, 4, 6 -> "good";
            case score2, 0 ->  {yield "bad"; }
            default -> { yield "unknown"; }
        };
        System.out.println(goal);
    }
}
