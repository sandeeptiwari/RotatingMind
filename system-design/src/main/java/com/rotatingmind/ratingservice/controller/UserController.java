package com.rotatingmind.ratingservice.controller;

import com.rotatingmind.ratingservice.domain.SurveyUser;
import com.rotatingmind.ratingservice.services.UserService;

import java.util.List;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public boolean assignSurvey(Long surveyId, Long userId) {
        return userService.assignSurvey(surveyId, userId);
    }

    public boolean assignSurvey(Long surveyId, List<Long> userIds) {
        return userService.assignSurveys(surveyId, userIds);
    }

    public SurveyUser registerUser(SurveyUser user) {
        return userService.addUser(user);
    }
}
