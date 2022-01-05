package com.rotatingmind.stackoverflow;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem70347726 {

    public static void main(String[] args) {

    }

    private static Map<String, Object> solution1(Map<String, Object> map) {
            Map<String, Object> mmm = new HashMap<>();
            /*for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Map) {
                    mmm.putAll(getMap((Map<String, Object>) value));
                    return mmm;
                }
                mmm.put(key, value);
            }*/

            return mmm;
    }

    @SuppressWarnings("unchecked")
    public static LinkedHashMap<String, Object> flatten(Map<String, Object> map) {
        return map.entrySet()
                .stream()
                .flatMap(e -> (e.getValue() instanceof Map)
                        ? flatten((Map<String, Object>) e.getValue()).entrySet().stream()
                        : Stream.of(e)
                )
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,
                        LinkedHashMap::new
                ));
    }
}
