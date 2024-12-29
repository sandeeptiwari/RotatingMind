package com.rotatingmind.hackthon.sorting;

import com.rotatingmind.hackthon.domain.Problem;

public class LikeBasedSorting implements ProblemSorting {
    @Override
    public int compare(Problem p1, Problem p2) {
        return p1.getLike().compareTo(p2.getLike());
    }
}
