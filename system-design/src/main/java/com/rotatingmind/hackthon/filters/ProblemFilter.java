package com.rotatingmind.hackthon.filters;

import com.rotatingmind.hackthon.domain.Problem;

public interface ProblemFilter {

    boolean filter(Problem problem);

}
