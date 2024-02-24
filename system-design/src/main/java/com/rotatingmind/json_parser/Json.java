package com.rotatingmind.json_parser;

import java.util.List;
import java.util.Map;

//data class
public class Json {
    private final Map<String, Json> keyToValues;

    public Json(Map<String, Json> keyToValues) {
        this.keyToValues = keyToValues;
    }

    public Json get(String key) {
        return this.keyToValues.get(key);
    }

  /*  public List<String> getAllKeys() {
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, JSON> jsonEntry : keyToValues.entrySet()) {
            keys.add(jsonEntry.getKey());
        }
        return keys;
    }*/

    public boolean isLeaf() {
        return (this.keyToValues.entrySet().size() == 1) &&
                (this.keyToValues.entrySet().iterator().next().getValue() == null);
    }

    public List<String> getAllKeys() {
        return keyToValues.keySet().stream().toList();
    }
}
