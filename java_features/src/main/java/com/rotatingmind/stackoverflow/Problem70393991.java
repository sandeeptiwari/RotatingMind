package com.rotatingmind.stackoverflow;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem70393991 {

    public static void main(String[] args) {
       Map<String, String> map = new HashMap<>();
       map.put("sandeep", "peon");
       map.put("Ramesh", "watchman");
       map.put("Sunder", "CEO");
       map.put("Roman", "Developer");

        JsonObject maptojson = maptojson(map);
        System.out.println(maptojson);
    }

    public static JsonObject maptojson(Map<String, String> map) {
        final JsonObject obj = new JsonObject();
        final JsonObject obj1 = new JsonObject();
        return map.entrySet()
                .stream()
                .map(entry -> {
                    obj.addProperty("key", entry.getKey());
                    obj.addProperty("val", entry.getValue());
                    return obj;
                })
                .reduce(obj1, (o1, o2) -> {
                   o1.addProperty(o2.get("key").getAsString(), o2.get("val").getAsString());
                    return o1;
                });
    }
}
