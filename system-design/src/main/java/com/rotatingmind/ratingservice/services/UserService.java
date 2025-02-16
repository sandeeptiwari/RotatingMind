package com.rotatingmind.ratingservice.services;

import com.rotatingmind.ratingservice.domain.SurveyUser;

import java.util.List;

public interface UserService {

    SurveyUser addUser(SurveyUser user);

    boolean assignSurvey(Long surveyId, Long userId);

    boolean assignSurveys(Long surveyId, List<Long> userIds);

}
