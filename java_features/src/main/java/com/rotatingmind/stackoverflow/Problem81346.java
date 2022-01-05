package com.rotatingmind.stackoverflow;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

//https://stackoverflow.com/questions/81346/most-efficient-way-to-increment-a-map-value-in-java
public class Problem81346 {

    public static void containsKeyMethod(String word) {
        Map<String, Integer> freq = new HashMap<String, Integer>();
        int count = freq.containsKey(word) ? freq.get(word) : 0;
        freq.put(word, count + 1);
    }

    public static void testForNullMethod(String word) {
        Map<String, Integer> freq = new HashMap<String, Integer>();
        Integer count = freq.get(word);
        if (count == null) {
            freq.put(word, 1);
        }
        else {
            freq.put(word, count + 1);
        }
    }

    public static void atomicLongMethod(String word) {
        final ConcurrentMap<String, AtomicLong> map =
                new ConcurrentHashMap<String, AtomicLong>();
        map.putIfAbsent(word, new AtomicLong(0));
        map.get(word).incrementAndGet();
    }

    public static void troveMethod(String word) {
        //TObjectIntHashMap<String> freq = new TObjectIntHashMap<String>();
        //freq.adjustOrPutValue(word, 1, 1);
    }

    public static void mutableIntMethod(String word) {
        Map<String, MutableInt> freq = new HashMap<String, MutableInt>();
        MutableInt count = freq.get(word);
        if (count == null) {
            freq.put(word, new MutableInt());
        }
        else {
            count.increment();
        }
    }
}

class MutableInt {
    int value = 1; // note that we start at 1 since we're counting
    public void increment () { ++value;      }
    public int  get ()       { return value; }
}