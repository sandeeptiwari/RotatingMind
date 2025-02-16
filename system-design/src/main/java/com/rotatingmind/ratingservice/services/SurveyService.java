package com.rotatingmind.ratingservice.services;

import com.rotatingmind.ratingservice.domain.Response;
import com.rotatingmind.ratingservice.domain.Survey;

import java.util.List;

public interface SurveyService {

    Survey create(Survey survey, Long userId);

    Survey addQuestions(Long surveyId, List<Long> questionIds, Long userId);

    Survey addQuestion(Long surveyId, Long questionId, Long userId);

    Double fetchSurveyRating(Long surveyId, Long userId);

    Survey findById(Long surveyId, Long userId);

    List<Survey> findAll(Long userId);

    boolean update(Survey survey);

    boolean delete(Long surveyId);

    boolean removeQuestion(Long surveyId, Long questionId, Long userId);

    boolean submit(Long surveyId, Long userId, Response response);

    boolean close(Long surveyId, Long userId);

    List<Response> getSurveyResponse(Long surveyId);
}
