package com.rotatingmind.array.hashmap;

import java.util.LinkedList;
import java.util.Objects;

public class MyHashMap {
    private static final float LOAD_FACTOR = 0.75f;
    private static final int INIT_SIZE = 16;

    private LinkedList<Entry>[] map;
    private int size; // number of key-value pairs

    private static class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this(INIT_SIZE);
    }

    public MyHashMap(int initialCapacity) {
        map = new LinkedList[initialCapacity];
        size = 0;
    }

    public void put(String key, String value) {
        if (needsRehash()) {
            rehashing();
        }

        int bucketIdx = hash(key);
        if (map[bucketIdx] == null) {
            map[bucketIdx] = new LinkedList<>();
        }

        for (Entry entry : map[bucketIdx]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        map[bucketIdx].add(new Entry(key, value));
        size++;
    }

    public String get(String key) {
        int bucketIdx = hash(key);
        LinkedList<Entry> bucket = map[bucketIdx];

        if (bucket == null) return null;

        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    private int hash(String key) {
        return Math.abs(Objects.hashCode(key)) % map.length;
    }

    private boolean needsRehash() {
        return size >= LOAD_FACTOR * map.length;
    }

    public void rehashing() {
        LinkedList<Entry>[] oldMap = map;
        map = new LinkedList[oldMap.length * 2];
        size = 0;

        for (LinkedList<Entry> bucket : oldMap) {
            if (bucket != null) {
                for (Entry entry : bucket) {
                    put(entry.key, entry.value); // Reinsert into new map
                }
            }
        }
    }

    public int capacity() {
        return map.length;
    }

    public int size() {
        return size;
    }

}
