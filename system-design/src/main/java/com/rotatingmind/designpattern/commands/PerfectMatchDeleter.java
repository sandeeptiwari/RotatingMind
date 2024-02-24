package com.rotatingmind.designpattern.commands;

import java.util.ArrayList;
import java.util.List;

public class PerfectMatchDeleter {

    public List<String> delete(String name) {
        if (name == null || name.length()  == 0)
            throw new IllegalArgumentException();
        List<String> tags = new ArrayList<>();
        Store.getTags().forEach(tag -> tags.add(tag));
        List<String> deletedStrings = new ArrayList<>();
        for (String tag : tags) {
            if (name.equals(tag)) {
                Store.delete(tag);
                deletedStrings.add(tag);
            }
        }
        return deletedStrings;
    }

}
