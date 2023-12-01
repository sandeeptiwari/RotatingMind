package com.rotatingmind.stackoverflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem74343585 {

    public static void main(String[] args) {
        Map<Integer, Map<String, List<String>>> ip = new HashMap<>();
        Map<String, List<String>> iip1 = new HashMap<>();
        List<String> ilp1 = new ArrayList<>();
        ilp1.add("Uno");
        ilp1.add("Dos");
        ilp1.add("Tres");
        iip1.put("Alpha", ilp1);

        Map<String, List<String>> iip2 = new HashMap<>();
        List<String> ilp2 = new ArrayList<>();
        ilp2.add("One");
        ilp2.add("Two");
        ilp2.add("Three");
        iip2.put("Beta", ilp2);

        Map<String, List<String>> iip3 = new HashMap<>();
        List<String> ilp3 = new ArrayList<>();
        ilp3.add("Eins");
        ilp3.add("Zwei");
        ilp3.add("Drei");
        iip3.put("Gamma", ilp3);

        ip.put(1, iip1);
        ip.put(2, iip2);
        ip.put(3, iip3);


        Map<String, String> op = ip.values().stream()
                .flatMap(ele -> ele.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get(0)));

        System.out.println(op);
    }
}
