package com.rotatingmind.stackoverflow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Problem70358485 {

    /**
     * Why do you want to use filter here at all? The filter over stream of entries shown in the question
     * iterates through all the members of the map ( O(n) ) However, the HashMap guarantees O(1)
     * access to "get" functionality. So why sacrifice performance here?
     *
     * If you want to check whether the map contains a key (ok, two keys), why not simply:
     *
     * if("1".equals(hashMap.get("RED")) && "2".equals(hashMap.get("BLUE"))) {
     *    // yes, this map indeed contains both elements
     *    // in case the "RED" is not in the map, the call to "get" will return null
     * }
     * @param args
     */
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("RED", "1");
        hashMap.put("BLUE", "2");
        hashMap.put("BLACK", "3");

        Map<String, String> filteredMap = hashMap.entrySet().stream()
               /* .filter(entry -> (entry.getKey().equals("RED") && entry.getValue().equals("1")
                        || (entry.getKey().equals("BLUE") && entry.getValue().equals("2"))))*/
                .filter(isMatch())
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        System.out.println(filteredMap);

        System.out.println("1".equals(null));
    }

    private static Predicate<Map.Entry<String, String>> isMatch() {
        Predicate<Map.Entry<String, String>> isRED = entry -> entry.getKey().equals("RED");
        Predicate<Map.Entry<String, String>> isREDValue = entry -> entry.getValue().equals("1");

        Predicate<Map.Entry<String, String>> isBlue = entry -> entry.getKey().equals("BLUE");
        Predicate<Map.Entry<String, String>> isBlueValue = entry -> entry.getValue().equals("2");

        return (isRED.and(isREDValue)).and(isBlue.and(isBlueValue));
    }
}
