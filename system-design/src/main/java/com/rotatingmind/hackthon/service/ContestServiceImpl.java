package com.rotatingmind.hackthon.service;

import com.rotatingmind.hackthon.domain.Problem;
import com.rotatingmind.hackthon.filters.FilterFactory;
import com.rotatingmind.hackthon.filters.ProblemFilter;
import com.rotatingmind.hackthon.repo.ContestRepository;
import com.rotatingmind.hackthon.repo.Repository;

import java.util.List;
import java.util.Map;

public class ContestServiceImpl implements ContestService {

    private final Repository<Problem, Long> contestRepository;

    public ContestServiceImpl() {
        this.contestRepository = new ContestRepository();
    }

    @Override
    public Problem addProblem(Problem problem) {
        return contestRepository.save(problem);
    }

    @Override
    public List<Problem> fetchProblem(Map<String, String> filterCriteria, Map<String, String> sortingCriteria) {
        List<Problem> problems = contestRepository.findAll();
        List<ProblemFilter> filters = filterCriteria.keySet()
                .stream()
                .map(s -> FilterFactory.getFilter(filterCriteria.getOrDefault(s, ""))).toList();

        return problems.stream()
                .filter(problem -> filters.stream().allMatch(filter -> filter.filter(problem)))
                .sorted()
                .toList();
    }
}
