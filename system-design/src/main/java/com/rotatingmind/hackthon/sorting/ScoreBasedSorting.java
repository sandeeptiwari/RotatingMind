package com.rotatingmind.hackthon.sorting;

import com.rotatingmind.hackthon.domain.Problem;

public class ScoreBasedSorting implements ProblemSorting {

    @Override
    public int compare(Problem p1, Problem p2) {
        return p1.getScore().compareTo(p2.getScore());
    }
}
