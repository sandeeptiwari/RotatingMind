package com.rotatingmind.hackthon;

import com.rotatingmind.hackthon.domain.HackthonUser;
import com.rotatingmind.hackthon.domain.Leader;
import com.rotatingmind.hackthon.domain.Problem;
import com.rotatingmind.hackthon.service.ContestService;
import com.rotatingmind.hackthon.service.ContestServiceImpl;
import com.rotatingmind.hackthon.service.UserService;
import com.rotatingmind.hackthon.service.UserServiceImpl;

import java.util.List;
import java.util.Map;

public class HackthonManager {

    private final UserService userService;
    private final ContestService contestService;


    public HackthonManager() {
        this.userService = new UserServiceImpl();
        this.contestService = new ContestServiceImpl();
    }

    // add User
    public HackthonUser addUser(HackthonUser user) {
        return userService.addUser(user);
    }

    // add problem
    public Problem addProblem(Problem problem) {
        return contestService.addProblem(problem);
    }

    // fetch problem
    public List<Problem> fetchProblems(Map<String, String> filterCriteria, Map<String, String> sortingCriteria) {
        return contestService.fetchProblem(filterCriteria, sortingCriteria);
    }

    // solve the problem, return top 5 recommendation
    public List<Problem> solve(Long problemId, Long userId) {
        return null;
    }

    //Fetch the list of solved problems for a user
    public List<Problem> fetchSolvedProblems(Long userId) {
        return null;
    }

    //Returns the name and department of the leader
    public List<Leader> getLeader() {
        return null;
    }
}
