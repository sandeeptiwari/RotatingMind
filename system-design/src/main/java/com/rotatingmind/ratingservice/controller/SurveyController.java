package com.rotatingmind.ratingservice.controller;

import com.rotatingmind.ratingservice.domain.Response;
import com.rotatingmind.ratingservice.domain.Survey;
import com.rotatingmind.ratingservice.services.SurveyService;

import java.util.List;

public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    public Survey createSurvey(Survey survey, Long userId) {
        return surveyService.create(survey, userId);
    }

    public Survey addQuestion(Long surveyId, Long questionId, Long userId) {
        return surveyService.addQuestion(surveyId, questionId, userId);
    }

    public Survey addQuestion(Long surveyId, List<Long> questionIds, Long userId) {
        return surveyService.addQuestions(surveyId, questionIds, userId);
    }

    public Double getSurveyRating(Long surveyId, Long userId) {
        return surveyService.fetchSurveyRating(surveyId, userId);
    }

    public Survey getSurvey(Long surveyId, Long userId) {
        return surveyService.findById(surveyId, userId);
    }

    public List<Survey> getAllSurveys(Long userId) {
        return surveyService.findAll(userId);
    }
    public boolean updateSurvey(Survey survey) {
        return surveyService.update(survey);
    }

    public boolean deleteSurvey(Long surveyId) {
        return surveyService.delete(surveyId);
    }

    public boolean removeQuestion(Long surveyId, Long questionId, Long userId) {
        return surveyService.removeQuestion(surveyId, questionId, userId);
    }

    public List<Response> getSurveyResponses(Long surveyId) {
        return surveyService.getSurveyResponse(surveyId);
    }

    public boolean closeSurvey(Long surveyId, Long userId) {
        return surveyService.close(surveyId, userId);
    }

    public boolean submit(Long surveyId, Long userId, Response response) {
        return surveyService.submit(surveyId, userId, response);
    }
}
