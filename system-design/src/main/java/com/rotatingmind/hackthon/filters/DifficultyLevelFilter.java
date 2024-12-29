package com.rotatingmind.hackthon.filters;

import com.rotatingmind.hackthon.domain.Problem;

public class DifficultyLevelFilter implements ProblemFilter {

    private final String currentDifficulty;

    public DifficultyLevelFilter(String currentDifficulty) {
        this.currentDifficulty = currentDifficulty;
    }

    @Override
    public boolean filter(Problem problem) {
        return currentDifficulty.equals(problem.getLevel().name());
    }
}
