package com.rotatingmind.designpattern.commands;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<String> tags = new ArrayList<>() {
        {
            add("knapsack");
            add("math");
            add("mathematics");
            add("sieve");
            add("runtime error");
        }
    };


    public static List<String> getTags() {
        return tags;
    }

    public static void delete(String tag) {
        System.out.println("Tag deleted : " + tag);
        tags.remove(tag);
    }

    public static void insert(String tag) {
        System.out.println("Inserted deleted : " + tag);
        tags.add(tag);
    }
}
