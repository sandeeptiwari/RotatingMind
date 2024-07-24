package com.rotatingmind;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V>{

    private final int capacity;
    private Map<Integer, Integer> cacheMap;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    @SuppressWarnings("unchecked")
    public V getOrDefault(int key) {
        return  super.getOrDefault(key, (V) Integer.valueOf(-1));
    }
}
