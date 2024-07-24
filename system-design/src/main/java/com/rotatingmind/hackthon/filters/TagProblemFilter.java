package com.rotatingmind.hackthon.filters;

import com.rotatingmind.hackthon.domain.Problem;

public class TagProblemFilter implements ProblemFilter {

    private final String tag;

    public TagProblemFilter(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean filter(Problem problem) {
        return tag.equals(problem.getTag());
    }
}
