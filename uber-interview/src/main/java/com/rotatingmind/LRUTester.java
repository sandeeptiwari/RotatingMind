package com.rotatingmind;

import java.util.Arrays;
import java.util.List;

public class LRUTester {

    public static void main(String[] args) {
        String[] commonds = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        List<List<Integer>> operations = List.of(
                List.of(2),
                List.of(1,1),
                List.of(2, 2),
                List.of(1),
                List.of(3, 3),
                List.of(2),
                List.of(4, 4),
                List.of(1),
                List.of(3),
                List.of(4));

        LRUCache<Integer, Integer> lRUCache = null;
        String[] result = new String[commonds.length];

        for (int i = 0; i < commonds.length; i++) {

            if (commonds[i].equals("LRUCache")) {
                lRUCache = new LRUCache<>(operations.get(i).get(0));
                result[i] = null;
            } else if (commonds[i].equals("put")) {
                lRUCache.put(operations.get(i).get(0), operations.get(i).get(1));
                result[i] = null;
            } else if (commonds[i].equals("get")) {
                result[i] = "" + lRUCache.getOrDefault(operations.get(i).get(0));;
            }
        }

        Arrays.stream(result).forEach(ele -> {
            System.out.print(ele + ", ");
        });
    }
}
