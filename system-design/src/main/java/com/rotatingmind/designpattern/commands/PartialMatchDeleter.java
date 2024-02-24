package com.rotatingmind.designpattern.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PartialMatchDeleter {

    public List<String> delete(Pattern pattern) {
            List<String> tags = new ArrayList<>();
            tags.addAll(Store.getTags());
            List<String> deletedStrings = new ArrayList<>();
            for(String tag : tags) {
                if (pattern.matcher(tag).matches()) {
                    Store.delete(tag);
                    deletedStrings.add(tag);
                }
            }
        return deletedStrings;
    }
}
