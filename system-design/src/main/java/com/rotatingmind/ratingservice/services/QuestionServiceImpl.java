package com.rotatingmind.ratingservice.services;

import com.rotatingmind.ratingservice.domain.Answer;
import com.rotatingmind.ratingservice.domain.Option;
import com.rotatingmind.ratingservice.domain.Question;
import com.rotatingmind.ratingservice.repository.QuestionRepository;
import com.rotatingmind.ratingservice.repository.ResponseRepositoryImpl;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ResponseRepositoryImpl resRepository;


    public QuestionServiceImpl(QuestionRepository questionRepository,
                               ResponseRepositoryImpl resRepository) {
        this.questionRepository = questionRepository;
        this.resRepository = resRepository;
    }

    @Override
    public Question create(Long id, String questionText, List<Option> options, Long userId) {
        Question question = Question.builder()
                .options(options)
                .questionId(id)
                .question(questionText)
                .build();
        return questionRepository.save(question).orElseThrow(() -> new RuntimeException("Question could not be saved"));
    }

    @Override
    public Double fetchQuestionRating(Long surveyId, Long questionId) {
        var responses = resRepository.findBySurveyId(surveyId);

        // Step 1: Collect answers by questionId
        var answers = responses.stream().flatMap(res -> res.getAnswers().stream())
                .filter(answer -> answer.getQuestionId().equals(questionId))
                .toList();


        return answers.stream()
                .mapToDouble(Answer::getWeightage)  // Use mapToDouble instead of collect()
                .average()
                .orElse(0.0); // Return 0.0 if no options exist
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public boolean update(Question question) {
        var newSurvey = questionRepository.save(question).orElseThrow(() -> new RuntimeException("Unable to update the question " + question.getQuestionId()));
        return true;
    }

    @Override
    public boolean delete(Long questionId) {
        questionRepository.delete(questionId);
        return true;
    }
}
