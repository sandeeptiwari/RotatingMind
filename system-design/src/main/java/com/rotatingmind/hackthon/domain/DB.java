package com.rotatingmind.hackthon.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Key(Long userId, Long problemId) {}
public class DB {
    private static DB instance = null;
    private Map<Long, HackthonUser> userTable = new HashMap<>();
    private Map<Long, Problem> problemTable = new HashMap<>();
    private Map<Key, List<Long>> solvedProblem = new HashMap<>();

    private DB() {}

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }

        return instance;
    }

    public Map<Long, HackthonUser> getUser() {
        return userTable;
    }

    public HackthonUser addUser(HackthonUser user) {
        long newId = userTable.keySet().stream().max(Long::compareTo).orElse(-1L) + 1L;
        user.setUserId(newId == 0 ? 1 : newId);
        userTable.put (user.getUserId(), user);
        return user;
    }

    public void putSolvedProblem(Key key, Long problemId) {
        solvedProblem.computeIfAbsent(key, k -> new ArrayList<>()).add(problemId);
    }

    public Problem addProblem(Problem problem) {
        long newId = problemTable.keySet().stream().max(Long::compareTo).orElse(-1L) + 1L;
        problem.setId(newId == 0 ? 1 : newId);
        problemTable.put(newId, problem);
        return problem;
    }


}
