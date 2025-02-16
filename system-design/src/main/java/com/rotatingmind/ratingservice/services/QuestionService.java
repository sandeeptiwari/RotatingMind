package com.rotatingmind.ratingservice.services;

import com.rotatingmind.ratingservice.domain.Option;
import com.rotatingmind.ratingservice.domain.Question;

import java.util.List;

public interface QuestionService {

    Question create(Long id, String questionText, List<Option> options, Long userId);

    Double fetchQuestionRating(Long surveyId, Long questionId);

    List<Question> findAll();

    boolean update(Question question);

    boolean delete(Long questionId);
}
