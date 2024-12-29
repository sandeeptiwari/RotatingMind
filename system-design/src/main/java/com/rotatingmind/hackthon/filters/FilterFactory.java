package com.rotatingmind.hackthon.filters;

public class FilterFactory {

    public static ProblemFilter getFilter(String name) {
        if (name.equals("TAG")) {
            return new TagProblemFilter(name);
        } else  {
            return new DifficultyLevelFilter(name);
        }
    }
}
