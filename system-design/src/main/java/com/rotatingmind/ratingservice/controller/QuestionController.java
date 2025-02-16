package com.rotatingmind.ratingservice.controller;

import com.rotatingmind.ratingservice.domain.Option;
import com.rotatingmind.ratingservice.domain.Question;
import com.rotatingmind.ratingservice.services.QuestionService;

import java.util.List;

public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Question createQuestion(Long id, String questionText, List<Option> options, Long userId) {
        return questionService.create(id, questionText, options, userId);
    }

    public Double getQuestionRating(Long surveyId, Long questionId) {
        return questionService.fetchQuestionRating(surveyId, questionId);
    }



    public List<Question> getQuestions(Long userId) {
        return questionService.findAll();
    }



    public boolean updateQuestion(Question question) {
        return questionService.update(question);
    }



    public boolean deleteQuestion(Long questionId) {
        return questionService.delete(questionId);
    }

}
