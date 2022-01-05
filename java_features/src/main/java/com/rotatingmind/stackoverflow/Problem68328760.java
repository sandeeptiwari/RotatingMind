package com.rotatingmind.stackoverflow;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//(AAA=((action1, 5),(action31, 2)), BBB=(action13, 7))
public class Problem68328760 {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Fridge", Action.ADD, new BigDecimal(15000)));
        products.add(new Product("Television", Action.ADD, new BigDecimal(25000)));
        products.add(new Product("Fan", Action.ADD, new BigDecimal(2500)));

        Map<String, Map<Action, BigDecimal>> collect = products.stream()
                .collect(Collectors.groupingBy(Product::getName,
                        Collectors.toMap(Product::getAction, Product::getPrice)));


        List<String> collect1 = Arrays.asList(1, 2).stream()
                .map((Integer s) -> "" + (s * s))
                .collect(Collectors.toCollection(ArrayList<String>::new));

        System.out.println(Stream.of(1, 2).map(s -> s * s).collect(Collectors.toList()));

    }

    private static Collector toCollect() {
        return null;
    }
}
