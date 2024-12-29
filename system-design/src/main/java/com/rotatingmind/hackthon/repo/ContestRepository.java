package com.rotatingmind.hackthon.repo;


import com.rotatingmind.hackthon.domain.DB;
import com.rotatingmind.hackthon.domain.HackthonUser;
import com.rotatingmind.hackthon.domain.Problem;

import java.util.List;

public class ContestRepository implements Repository<Problem, Long> {


    @Override
    public Problem save(Problem problem) {
        return DB.getInstance().addProblem(problem);
    }

    @Override
    public Problem findById(Long id) {
        return null;
    }

    @Override
    public List<Problem> findAll() {
        return List.of();
    }
}
