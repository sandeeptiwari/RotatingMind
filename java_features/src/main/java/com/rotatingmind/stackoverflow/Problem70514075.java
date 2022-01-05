package com.rotatingmind.stackoverflow;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem70514075 {
    private enum Fizzbuzz {
        DIV_BY_THREE, DIV_BY_FIVE, DIV_BY_BOTH, DIV_BY_NEITHER;

        static public Fizzbuzz classify(int i) {
            if (i % 3 == 0) {
                return i % 5 == 0 ? DIV_BY_BOTH : DIV_BY_THREE;
            } else if (i % 5 == 0) {
                return DIV_BY_FIVE;
            } else {
                return DIV_BY_NEITHER;
            }
        }
    }

    //l3 = [3,24] , l5 = [5,20,25], l35 = [45,30]
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(24);
        list.add(25);
        list.add(45);
        list.add(30);
        list.add(3);
        list.add(20);
        list.add(5);
        // method3(list);
        System.out.println(method3(list));
    }

    private static Map<String, List<Integer>> method3(ArrayList<Integer> list) {
        Function<Integer, String> classifier = n -> (n % 3 == 0) ? ((n % 5 == 0) ? "l35" : "l3") : (n % 5 == 0) ? "l5" : "NONE";
        return list.stream().collect(Collectors.groupingBy(classifier));
    }

    private static  Map<Fizzbuzz, List<Integer>> method2(ArrayList<Integer> list) {
        return list.stream().collect(Collectors.groupingBy(Fizzbuzz::classify));
    }

    private static void method1(ArrayList<Integer> list) {
        Map<String, List<Integer>> fizzBuzz = new HashMap<>(3);
        fizzBuzz.put("I", new ArrayList());
        fizzBuzz.put("I3", new ArrayList());
        fizzBuzz.put("I5", new ArrayList());
        fizzBuzz.put("I35", new ArrayList());

        list.stream().reduce(fizzBuzz,
                (map, e) -> {
                    String key = "I"; //default key
                    if (e % 3 == 0) key = "I3";
                    if (e % 5 == 0) key = "I5";
                    if (e % (3 * 5) == 0) key = "I35";
                    map.get(key).add(e);
                    return map;
                },
                (m, m2) -> {
                    m.putAll(m2);
                    return m;
                });
        System.out.println(fizzBuzz);
    }
}
