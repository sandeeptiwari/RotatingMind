package com.rotatingmind.hackthon.service;

import com.rotatingmind.hackthon.domain.Problem;

import java.util.List;
import java.util.Map;

public interface ContestService {

    Problem addProblem(Problem problem);

    List<Problem> fetchProblem(Map<String, String> filterCriteria, Map<String, String> sortingCriteria);
}
